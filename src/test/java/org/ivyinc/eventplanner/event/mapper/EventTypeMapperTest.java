package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.event.builder.EventTypeBuilder;
import org.ivyinc.eventplanner.event.dto.EventTypeCreateDto;
import org.ivyinc.eventplanner.event.dto.EventTypeResponseDto;
import org.ivyinc.eventplanner.event.dto.EventTypeUpdateDto;
import org.ivyinc.eventplanner.event.model.EventType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest
@ActiveProfiles("test")
class EventTypeMapperTest {

    @Autowired
    private EventTypeMapper mapper;

    private final EventTypeBuilder builder = new EventTypeBuilder();

    @Test
    @DisplayName("toEntity should map eventCategoryId to eventCategory reference and fields")
    void toEntity_shouldMapCreateDto() {
        EventTypeCreateDto create = builder.sampleCreateDto();
        EventType entity = mapper.toEntity(create);
        assertSoftly(softly -> {
            softly.assertThat(entity).isNotNull();
            softly.assertThat(entity.getEventCategory()).isNotNull();
            softly.assertThat(entity.getEventCategory().getId()).isEqualTo(create.eventCategoryId());
            softly.assertThat(entity.getName()).isEqualTo(create.name());
            softly.assertThat(entity.getDescription()).isEqualTo(create.description());
        });
    }

    @Test
    @DisplayName("toResponse should map nested eventCategory via EventCategoryMapper")
    void toResponse_shouldMapEntity() {
        EventType entity = builder.sampleEntity();
        entity.setId(UUID.randomUUID());
        EventTypeResponseDto response = mapper.toResponse(entity);
        assertSoftly(softly -> {
            softly.assertThat(response).isNotNull();
            softly.assertThat(response.id()).isEqualTo(entity.getId());
            softly.assertThat(response.eventCategory()).isNotNull();
            softly.assertThat(response.name()).isEqualTo(entity.getName());
            softly.assertThat(response.description()).isEqualTo(entity.getDescription());
        });
    }

    @Test
    @DisplayName("updateEntity should update non-null fields and map category id")
    void updateEntity_shouldUpdateAndIgnoreNulls() {
        EventType entity = builder.sampleEntity();
        EventTypeUpdateDto update = builder.sampleUpdateDto();
        mapper.updateEntity(entity, update);
        assertSoftly(softly -> {
            softly.assertThat(entity.getEventCategory()).isNotNull();
            softly.assertThat(entity.getEventCategory().getId()).isEqualTo(update.eventCategoryId());
            softly.assertThat(entity.getName()).isEqualTo(update.name());
            softly.assertThat(entity.getDescription()).isEqualTo(update.description());
        });
    }
}
