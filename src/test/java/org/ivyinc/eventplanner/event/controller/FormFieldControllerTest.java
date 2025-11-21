package org.ivyinc.eventplanner.event.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ivyinc.eventplanner.common.controller.BaseControllerTest;
import org.ivyinc.eventplanner.common.helper.CrudTestHelper;
import org.ivyinc.eventplanner.event.builder.FormFieldBuilder;
import org.ivyinc.eventplanner.event.dto.FormFieldCreateDto;
import org.ivyinc.eventplanner.event.dto.FormFieldResponseDto;
import org.ivyinc.eventplanner.event.dto.FormFieldUpdateDto;
import org.ivyinc.eventplanner.event.service.FormFieldService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = FormFieldController.class)
@AutoConfigureMockMvc(addFilters = false)
class FormFieldControllerTest extends BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private FormFieldService formFieldService;

    private final FormFieldBuilder builder = new FormFieldBuilder();

    @Test
    @DisplayName("Full CRUD flow for /v1/api/form-fields endpoint")
    void testCrudFlowForFormFields() throws Exception {
        CrudTestHelper<FormFieldCreateDto, FormFieldUpdateDto, FormFieldResponseDto, FormFieldService> helper =
                new CrudTestHelper<>(
                        mockMvc,
                        objectMapper,
                        formFieldService,
                        "/v1/api/form-fields",
                        builder
                );
        helper.testCrudFlow();
    }
}
