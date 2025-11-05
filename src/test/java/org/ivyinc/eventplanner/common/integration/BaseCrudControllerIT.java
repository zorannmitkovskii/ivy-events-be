package org.ivyinc.eventplanner.common.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.UUID;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc(addFilters = false)
public abstract class BaseCrudControllerIT<
        CreateDto,
        UpdateDto,
        ResponseDto
        > {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    /**
     * Override these methods in your concrete IT class below
     */
    protected abstract String getBasePath();

    protected abstract CreateDto sampleCreateDto();
    protected abstract UpdateDto sampleUpdateDto();
    protected abstract void assertCreateAssertions(ResponseDto dto);
    protected abstract void assertUpdateAssertions(ResponseDto dto);

    @Test
    void crudFlow() throws Exception {
        // CREATE
        MvcResult createRes = mockMvc.perform(post(getBasePath())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleCreateDto()))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String createContent = createRes.getResponse().getContentAsString();
        ResponseDto createdDto = objectMapper.readValue(createContent, getResponseDtoClass());
        UUID id = extractId(createdDto);

        assertCreateAssertions(createdDto);

        // READ BY ID
        mockMvc.perform(get(getBasePath() + "/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // UPDATE
        MvcResult updateRes = mockMvc.perform(put(getBasePath() + "/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleUpdateDto()))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String updateContent = updateRes.getResponse().getContentAsString();
        ResponseDto updatedDto = objectMapper.readValue(updateContent, getResponseDtoClass());
        assertUpdateAssertions(updatedDto);

        // LIST
        mockMvc.perform(get(getBasePath()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", not(empty())));

        // DELETE
        mockMvc.perform(delete(getBasePath() + "/" + id))
                .andExpect(status().isNoContent());

        // READ AGAIN (after delete)
        mockMvc.perform(get(getBasePath() + "/" + id))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    /**
     * These should be overridden in your subclass to specify ID extraction and DTO class.
     */
    protected abstract Class<ResponseDto> getResponseDtoClass();

    protected abstract UUID extractId(ResponseDto dto);
}
