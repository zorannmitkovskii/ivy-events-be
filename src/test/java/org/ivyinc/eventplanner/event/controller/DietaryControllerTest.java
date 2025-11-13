package org.ivyinc.eventplanner.event.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.common.controller.BaseControllerTest;
import org.ivyinc.eventplanner.common.helper.CrudTestHelper;
import org.ivyinc.eventplanner.event.builder.DietaryBuilder;
import org.ivyinc.eventplanner.event.dto.DietaryCreateDto;
import org.ivyinc.eventplanner.event.dto.DietaryResponseDto;
import org.ivyinc.eventplanner.event.dto.DietaryUpdateDto;
import org.ivyinc.eventplanner.event.service.DietaryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = DietaryController.class)
@AutoConfigureMockMvc(addFilters = false)
class DietaryControllerTest extends BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private DietaryService dietaryService;

    // Your builder that provides sample DTOs
    private final DtoBuilder<DietaryCreateDto, DietaryUpdateDto, DietaryResponseDto> dietaryDtoBuilder =
            new DietaryBuilder();

    @Test
    @DisplayName("Full CRUD flow for /v1/api/dietaries endpoint")
    void testCrudFlowForDietary() throws Exception {
        CrudTestHelper<DietaryCreateDto, DietaryUpdateDto, DietaryResponseDto, DietaryService> helper =
                new CrudTestHelper<>(
                        mockMvc,
                        objectMapper,
                        dietaryService,
                        "/v1/api/dietaries",
                        dietaryDtoBuilder
                );

        helper.testCrudFlow();
    }
}
