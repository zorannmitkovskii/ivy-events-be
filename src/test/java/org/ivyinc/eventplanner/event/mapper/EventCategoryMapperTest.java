package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.event.builder.EventCategoryBuilder;
import org.ivyinc.eventplanner.event.dto.EventCategoryCreateDto;
import org.ivyinc.eventplanner.event.dto.EventCategoryResponseDto;
import org.ivyinc.eventplanner.event.dto.EventCategoryUpdateDto;
import org.ivyinc.eventplanner.event.model.EventCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest
@ActiveProfiles("test")
class EventCategoryMapperTest {

    @Autowired
    private EventCategoryMapper mapper;

    private final EventCategoryBuilder builder = new EventCategoryBuilder.Corporate();

    @Test
    @DisplayName("toEntity should map basic fields")
    void toEntity_shouldMapCreateDto() {
        EventCategoryCreateDto create = builder.sampleCreateDto();
        EventCategory entity = mapper.toEntity(create);
        assertSoftly(softly -> {
            softly.assertThat(entity).isNotNull();
            softly.assertThat(entity.getName()).isEqualTo(create.name());
            softly.assertThat(entity.getDescription()).isEqualTo(create.description());
        });
    }

    @Test
    @DisplayName("toResponse should map entity -> dto")
    void toResponse_shouldMapEntity() {
        EventCategory entity = builder.sampleEntity();
        entity.setId(UUID.randomUUID());
        EventCategoryResponseDto response = mapper.toResponse(entity);
        assertSoftly(softly -> {
            softly.assertThat(response).isNotNull();
            softly.assertThat(response.id()).isEqualTo(entity.getId());
            softly.assertThat(response.name()).isEqualTo(entity.getName());
            softly.assertThat(response.description()).isEqualTo(entity.getDescription());
        });
    }

    @Test
    @DisplayName("updateEntity should update non-null fields")
    void updateEntity_shouldUpdateAndIgnoreNulls() {
        EventCategory entity = builder.sampleEntity();
        EventCategoryUpdateDto update = builder.sampleUpdateDto();
        mapper.updateEntity(entity, update);
        assertSoftly(softly -> {
            softly.assertThat(entity.getName()).isEqualTo(update.name());
            softly.assertThat(entity.getDescription()).isEqualTo(update.description());
        });
    }
}
