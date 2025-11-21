package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.EventCategoryCreateDto;
import org.ivyinc.eventplanner.event.dto.EventCategoryUpdateDto;
import org.ivyinc.eventplanner.event.dto.EventCategoryResponseDto;
import org.ivyinc.eventplanner.event.model.EventCategory;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class EventCategoryBuilder implements DtoBuilder<EventCategory, EventCategoryCreateDto, EventCategoryUpdateDto, EventCategoryResponseDto> {

    @Override
    public abstract EventCategory sampleEntity();

    @Override
    public abstract EventCategoryCreateDto sampleCreateDto();

    @Override
    public abstract EventCategoryUpdateDto sampleUpdateDto();

    @Override
    public EventCategoryResponseDto sampleCreateResponse(UUID id) {
        return new EventCategoryResponseDto(
                id,
                sampleEntity().getName(),
                sampleEntity().getDescription(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public EventCategoryResponseDto sampleUpdateResponse(UUID id) {
        return new EventCategoryResponseDto(
                id,
                sampleUpdateDto().name(),
                sampleUpdateDto().description(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public Class<EventCategoryResponseDto> responseDtoClass() {
        return EventCategoryResponseDto.class;
    }

    // ---------- Static subclasses for specific categories ----------

    public static class Corporate extends EventCategoryBuilder {

        @Override
        public EventCategory sampleEntity() {
            return EventCategory.builder()
                    .name("Corporate Events")
                    .description("Business-oriented events such as meetings, conferences, and galas.")
                    .build();
        }

        @Override
        public EventCategoryCreateDto sampleCreateDto() {
            return new EventCategoryCreateDto(
                    "Corporate Events",
                    "Business-oriented events such as meetings, conferences, and galas."
            );
        }

        @Override
        public EventCategoryUpdateDto sampleUpdateDto() {
            return new EventCategoryUpdateDto(
                    "Updated Corporate Events",
                    "Updated description for corporate events category."
            );
        }
    }

    public static class Social extends EventCategoryBuilder {

        @Override
        public EventCategory sampleEntity() {
            return EventCategory.builder()
                    .name("Social Events")
                    .description("Personal celebrations such as weddings, birthdays, and anniversaries.")
                    .build();
        }

        @Override
        public EventCategoryCreateDto sampleCreateDto() {
            return new EventCategoryCreateDto(
                    "Social Events",
                    "Personal celebrations such as weddings, birthdays, and anniversaries."
            );
        }

        @Override
        public EventCategoryUpdateDto sampleUpdateDto() {
            return new EventCategoryUpdateDto(
                    "Updated Social Events",
                    "Updated description for social events category."
            );
        }
    }
}
