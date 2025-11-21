package org.ivyinc.eventplanner.event.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ivyinc.eventplanner.common.controller.BaseControllerTest;
import org.ivyinc.eventplanner.common.helper.CrudTestHelper;
import org.ivyinc.eventplanner.event.builder.RegistrationFormBuilder;
import org.ivyinc.eventplanner.event.dto.FormCreateDto;
import org.ivyinc.eventplanner.event.dto.FormResponseDto;
import org.ivyinc.eventplanner.event.dto.FormUpdateDto;
import org.ivyinc.eventplanner.event.service.FormService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = FormController.class)
@AutoConfigureMockMvc(addFilters = false)
class FormControllerTest extends BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private FormService formService;

    private final RegistrationFormBuilder builder = new RegistrationFormBuilder();

    @Test
    @DisplayName("Full CRUD flow for /v1/api/forms endpoint")
    void testCrudFlowForForms() throws Exception {
        CrudTestHelper<FormCreateDto, FormUpdateDto, FormResponseDto, FormService> helper =
                new CrudTestHelper<>(
                        mockMvc,
                        objectMapper,
                        formService,
                        "/v1/api/forms",
                        builder
                );
        helper.testCrudFlow();
    }
}
