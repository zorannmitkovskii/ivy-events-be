package org.ivyinc.eventplanner.event.controller;

import org.ivyinc.eventplanner.common.controller.BaseControllerTest;
import org.ivyinc.eventplanner.event.builder.BandDtoBuilder;
import org.ivyinc.eventplanner.event.dto.BandCreateDto;
import org.ivyinc.eventplanner.event.dto.BandResponseDto;
import org.ivyinc.eventplanner.event.dto.BandUpdateDto;
import org.ivyinc.eventplanner.event.service.BandService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = BandController.class)
@AutoConfigureMockMvc(addFilters = false)
class BandControllerTest extends BaseControllerTest {

    private final BandDtoBuilder bandDtoBuilder = new BandDtoBuilder();

    @MockBean
    private BandService bandService;

    @Override
    protected String getBasePath() {
        return "/v1/api/bands";
    }

    @Test
    @DisplayName("POST /v1/api/bands should delegate to service and return response body")
    void testCreate() throws Exception {
        UUID id = UUID.randomUUID();
        BandResponseDto response = bandDtoBuilder.sampleResponse(id);
        when(bandService.create(any(BandCreateDto.class))).thenReturn(response);

        mockMvc.perform(post(getBasePath())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bandDtoBuilder.sampleCreateDto())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.name").value("The Band"));
    }

    @Test
    @DisplayName("PUT /v1/api/bands/{id} should update and return response")
    void testUpdate() throws Exception {
        UUID id = UUID.randomUUID();
        BandResponseDto response = bandDtoBuilder.sampleResponse(id);
        when(bandService.update(eq(id.toString()), any(BandUpdateDto.class))).thenReturn(response);

        mockMvc.perform(put(getBasePath() + "/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bandDtoBuilder.sampleUpdateDto())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.name").value("The Band"));
    }

    @Test
    @DisplayName("GET /v1/api/bands/{id} should return a single band")
    void testGetById() throws Exception {
        UUID id = UUID.randomUUID();
        BandResponseDto response = bandDtoBuilder.sampleResponse(id);
        when(bandService.findById(id.toString())).thenReturn(response);

        mockMvc.perform(get(getBasePath() + "/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()));
    }

    @Test
    @DisplayName("GET /v1/api/bands should return list of bands")
    void testGetAll() throws Exception {
        BandResponseDto r1 = bandDtoBuilder.sampleResponse(UUID.randomUUID());
        BandResponseDto r2 = bandDtoBuilder.sampleResponse(UUID.randomUUID());
        when(bandService.findAll()).thenReturn(List.of(r1, r2));

        mockMvc.perform(get(getBasePath()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("The Band"))
                .andExpect(jsonPath("$[1].name").value("The Band"));
    }

    @Test
    @DisplayName("DELETE /v1/api/bands/{id} should return 204 No Content")
    void testDelete() throws Exception {
        UUID id = UUID.randomUUID();
        Mockito.doNothing().when(bandService).delete(id.toString());

        mockMvc.perform(delete(getBasePath() + "/{id}", id))
                .andExpect(status().isNoContent());
    }
}
