package org.ivyinc.eventplanner.common.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class CrudTestHelper<
        CREATE_DTO,
        UPDATE_DTO,
        RESPONSE_DTO,
        SERVICE extends BaseService<?, CREATE_DTO, UPDATE_DTO, RESPONSE_DTO>> {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;
    private final SERVICE service;
    private final String basePath;
    private final DtoBuilder<?, CREATE_DTO, UPDATE_DTO, RESPONSE_DTO> builder;

    public CrudTestHelper(MockMvc mockMvc,
                          ObjectMapper objectMapper,
                          SERVICE service,
                          String basePath,
                          DtoBuilder<?, CREATE_DTO, UPDATE_DTO, RESPONSE_DTO> builder) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
        this.service = service;
        this.basePath = basePath;
        this.builder = builder;
    }

    public void testCrudFlow() throws Exception {
        UUID id = UUID.randomUUID();
        RESPONSE_DTO expected = builder.sampleCreateResponse(id);

        // --- CREATE ---
        when(service.create(any())).thenReturn(expected);

        MvcResult createResult = mockMvc.perform(post(basePath)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(builder.sampleCreateDto())))
                .andReturn();

        RESPONSE_DTO created = objectMapper.readValue(
                createResult.getResponse().getContentAsString(),
                builder.responseDtoClass()
        );

        assertThat(created)
                .usingRecursiveComparison()
                .isEqualTo(expected);

        // --- UPDATE ---
        RESPONSE_DTO updatedExpected = builder.sampleUpdateResponse(id);
        when(service.update(eq(id.toString()), any())).thenReturn(updatedExpected);

        MvcResult updateResult = mockMvc.perform(put(basePath + "/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(builder.sampleUpdateDto())))
                .andReturn();

        RESPONSE_DTO updated = objectMapper.readValue(
                updateResult.getResponse().getContentAsString(),
                builder.responseDtoClass()
        );

        assertThat(updated)
                .usingRecursiveComparison()
                .isEqualTo(updatedExpected);

        // --- GET BY ID ---
        when(service.findById(id.toString())).thenReturn(expected);

        MvcResult getResult = mockMvc.perform(get(basePath + "/{id}", id))
                .andReturn();

        RESPONSE_DTO found = objectMapper.readValue(
                getResult.getResponse().getContentAsString(),
                builder.responseDtoClass()
        );

        assertThat(found)
                .usingRecursiveComparison()
                .isEqualTo(expected);

        // --- GET ALL ---
        RESPONSE_DTO r1 = builder.sampleCreateResponse(UUID.randomUUID());
        RESPONSE_DTO r2 = builder.sampleCreateResponse(UUID.randomUUID());
        when(service.findAll()).thenReturn(List.of(r1, r2));

        MvcResult listResult = mockMvc.perform(get(basePath)).andReturn();

        List<RESPONSE_DTO> all = objectMapper.readValue(
                listResult.getResponse().getContentAsString(),
                objectMapper.getTypeFactory()
                        .constructCollectionType(List.class, builder.responseDtoClass())
        );

        assertThat(all)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly(r1, r2);

        // --- DELETE ---
        doNothing().when(service).delete(id.toString());

        MvcResult deleteResult = mockMvc.perform(delete(basePath + "/{id}", id))
                .andReturn();

        assertThat(deleteResult.getResponse().getStatus()).isEqualTo(204);
    }
}
