package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.event.builder.FormFieldBuilder;
import org.ivyinc.eventplanner.event.dto.FormFieldCreateDto;
import org.ivyinc.eventplanner.event.dto.FormFieldResponseDto;
import org.ivyinc.eventplanner.event.dto.FormFieldUpdateDto;
import org.ivyinc.eventplanner.event.model.FormField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest
@ActiveProfiles("test")
class FormFieldMapperTest {

    @Autowired
    private FormFieldMapper mapper;

    private final FormFieldBuilder builder = new FormFieldBuilder();

    @Test
    @DisplayName("toEntity should map create dto")
    void toEntity_shouldMapCreateDto() {
        FormFieldCreateDto create = builder.sampleCreateDto();
        FormField entity = mapper.toEntity(create);
        FormFieldResponseDto response = mapper.toResponse(entity);
        assertSoftly(softly -> {
            softly.assertThat(response).isNotNull();
            softly.assertThat(response.label()).isEqualTo(create.label());
            softly.assertThat(response.type()).isEqualTo(create.type());
            softly.assertThat(response.orderIndex()).isEqualTo(create.orderIndex());
            softly.assertThat(response.required()).isEqualTo(create.required());
            softly.assertThat(response.placeholder()).isEqualTo(create.placeholder());
            softly.assertThat(response.validationRegex()).isEqualTo(create.validationRegex());
        });
    }

    @Test
    @DisplayName("toResponse should map entity basic props")
    void toResponse_shouldMapEntity() {
        FormField entity = builder.sampleEntity();
        entity.setId(UUID.randomUUID());
        FormFieldResponseDto response = mapper.toResponse(entity);
        assertSoftly(softly -> {
            softly.assertThat(response).isNotNull();
            softly.assertThat(response.id()).isEqualTo(entity.getId());
            // assert known values from builder.sampleEntity()
            softly.assertThat(response.label()).isEqualTo("Full Name");
            softly.assertThat(response.type()).isNotNull();
            softly.assertThat(response.orderIndex()).isEqualTo(1);
            softly.assertThat(response.required()).isTrue();
            softly.assertThat(response.placeholder()).isEqualTo("Enter your full name");
        });
    }

    @Test
    @DisplayName("updateEntity should update non-null fields and ignore nulls")
    void updateEntity_shouldUpdateAndIgnoreNulls() {
        FormField entity = builder.sampleEntity();
        FormFieldUpdateDto update = builder.sampleUpdateDto();
        mapper.updateEntity(entity, update);
        FormFieldResponseDto response = mapper.toResponse(entity);
        assertSoftly(softly -> {
            softly.assertThat(response.label()).isEqualTo(update.label());
            softly.assertThat(response.type()).isEqualTo(update.type());
            softly.assertThat(response.orderIndex()).isEqualTo(update.orderIndex());
            softly.assertThat(response.required()).isEqualTo(Boolean.TRUE.equals(update.required()));
            softly.assertThat(response.placeholder()).isEqualTo(update.placeholder());
        });
    }
}
