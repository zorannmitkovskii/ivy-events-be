package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.model.Form;

import java.util.List;

public class RegistrationFormBuilder extends FormBuilder {

    private final FormFieldBuilder nameField = new FormFieldBuilder();
    private final FormFieldBuilder.EmailField emailField = new FormFieldBuilder.EmailField();
    private final FormFieldBuilder.YesNoSelectField subscribeField = new FormFieldBuilder.YesNoSelectField();

    @Override
    public Form sampleEntity() {
        return Form.builder()
                .name("Registration Form")
                .version(1)
                .build();
    }

    @Override
    public FormCreateDto sampleCreateDto() {
        return new FormCreateDto(
                "Registration Form",
                1,
                sampleCreateFields()
        );
    }

    @Override
    public FormUpdateDto sampleUpdateDto() {
        return new FormUpdateDto(
                "Registration Form v2",
                2,
                sampleUpdateFields()
        );
    }

    @Override
    protected List<FormFieldCreateDto> sampleCreateFields() {
        return List.of(
                nameField.sampleCreateDto(),
                emailField.sampleCreateDto(),
                subscribeField.sampleCreateDto()
        );
    }

    @Override
    protected List<FormFieldUpdateDto> sampleUpdateFields() {
        // mimic a re-order and slight text changes in update
        var nameUpdate = nameField.sampleUpdateDto();
        var emailUpdate = emailField.sampleUpdateDto();
        return List.of(
                emailUpdate,
                nameUpdate
                // omit subscribe field to simulate removal/update scenarios
        );
    }
}
