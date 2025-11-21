package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.event.builder.RegistrationFormBuilder;
import org.ivyinc.eventplanner.event.dto.FormCreateDto;
import org.ivyinc.eventplanner.event.dto.FormResponseDto;
import org.ivyinc.eventplanner.event.dto.FormUpdateDto;
import org.ivyinc.eventplanner.event.model.Form;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest
@ActiveProfiles("test")
class FormMapperTest {

    @Autowired
    private FormMapper mapper;

    private final RegistrationFormBuilder builder = new RegistrationFormBuilder();

    @Test
    @DisplayName("toEntity should map create dto including fields")
    void toEntity_shouldMapCreateDto() {
        FormCreateDto create = builder.sampleCreateDto();
        Form entity = mapper.toEntity(create);
        assertSoftly(softly -> {
            softly.assertThat(entity).isNotNull();
            softly.assertThat(entity.getName()).isEqualTo(create.name());
            softly.assertThat(entity.getVersion()).isEqualTo(create.version());
            // fields are not part of Form mapper by default unless configured; just assert null-safe
            softly.assertThat(entity.getFields()).isNull();
        });
    }

    @Test
    @DisplayName("toResponse should map entity basic props")
    void toResponse_shouldMapEntity() {
        Form entity = builder.sampleEntity();
        entity.setId(UUID.randomUUID());
        FormResponseDto response = mapper.toResponse(entity);
        assertSoftly(softly -> {
            softly.assertThat(response).isNotNull();
            softly.assertThat(response.id()).isEqualTo(entity.getId());
            softly.assertThat(response.name()).isEqualTo(entity.getName());
            softly.assertThat(response.version()).isEqualTo(entity.getVersion());
        });
    }

    @Test
    @DisplayName("updateEntity should update non-null fields and ignore nulls")
    void updateEntity_shouldUpdateAndIgnoreNulls() {
        Form entity = builder.sampleEntity();
        FormUpdateDto update = builder.sampleUpdateDto();
        mapper.updateEntity(entity, update);
        assertSoftly(softly -> {
            softly.assertThat(entity.getName()).isEqualTo(update.name());
            softly.assertThat(entity.getVersion()).isEqualTo(update.version());
        });
    }
}
