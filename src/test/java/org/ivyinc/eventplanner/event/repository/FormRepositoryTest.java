package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.event.enums.FieldType;
import org.ivyinc.eventplanner.event.model.Form;
import org.ivyinc.eventplanner.event.model.FormField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class FormRepositoryTest {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private FormFieldRepository formFieldRepository;

    private Form newFormWithTwoFields() {
        Form form = Form.builder()
                .name("Registration Form")
                .version(1)
                .build();

        FormField f1 = FormField.builder()
                .label("Full Name")
                .type(FieldType.TEXT)
                .orderIndex(1)
                .required(true)
                .placeholder("Enter your full name")
                .build();
        f1.setForm(form);

        FormField f2 = FormField.builder()
                .label("Email")
                .type(FieldType.EMAIL)
                .orderIndex(2)
                .required(true)
                .placeholder("name@example.com")
                .build();
        f2.setForm(form);

        List<FormField> fields = new ArrayList<>();
        fields.add(f1);
        fields.add(f2);
        form.setFields(fields);
        return form;
    }

    @Test
    @DisplayName("Saving a Form cascades to FormField children")
    void saveForm_cascadesToFields() {
        Form form = newFormWithTwoFields();
        Form saved = formRepository.save(form);

        assertThat(saved.getId()).isNotNull();
        assertThat(formFieldRepository.count()).isEqualTo(2);
    }

    @Test
    @DisplayName("Removing child from Form.fields with orphanRemoval deletes it")
    void orphanRemoval_removesChildField() {
        Form saved = formRepository.save(newFormWithTwoFields());
        assertThat(formFieldRepository.count()).isEqualTo(2);

        // remove first field
        saved.getFields().remove(0);
        formRepository.save(saved);

        assertThat(formFieldRepository.count()).isEqualTo(1);
    }
}
