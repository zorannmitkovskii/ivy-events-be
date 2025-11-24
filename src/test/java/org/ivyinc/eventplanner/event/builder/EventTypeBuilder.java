package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.EventCategoryResponseDto;
import org.ivyinc.eventplanner.event.dto.EventTypeCreateDto;
import org.ivyinc.eventplanner.event.dto.EventTypeResponseDto;
import org.ivyinc.eventplanner.event.dto.EventTypeUpdateDto;
import org.ivyinc.eventplanner.event.model.EventCategory;
import org.ivyinc.eventplanner.event.model.EventType;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventTypeBuilder implements DtoBuilder<EventType, EventTypeCreateDto, EventTypeUpdateDto, EventTypeResponseDto> {

    private final EventCategoryBuilder.Corporate categoryBuilder = new EventCategoryBuilder.Corporate();
    private final EventCategory category = categoryBuilder.sampleEntity();

    private final UUID categoryId = UUID.randomUUID();

    @Override
    public EventType sampleEntity() {
        return EventType.builder()
                .eventCategory(category)
                .name("Conference")
                .description("Formal corporate conference")
                .iconUrl("https://cdn.ivyinc.com/icons/conference.png")
                .isActive(true)
                .build();
    }

    @Override
    public EventTypeCreateDto sampleCreateDto() {
        return new EventTypeCreateDto(
                categoryId,
                "Conference",
                "Formal corporate conference"
        );
    }

    @Override
    public EventTypeUpdateDto sampleUpdateDto() {
        return new EventTypeUpdateDto(
                categoryId,
                "Conference (Updated)",
                "Updated description"
        );
    }

    private EventCategoryResponseDto categoryResponse(UUID id) {
        var c = categoryBuilder.sampleCreateDto();
        return new EventCategoryResponseDto(
                id,
                c.name(),
                c.description(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public EventTypeResponseDto sampleCreateResponse(UUID id) {
        var c = sampleCreateDto();
        return new EventTypeResponseDto(
                id,
                categoryResponse(categoryId),
                c.name(),
                c.description(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public EventTypeResponseDto sampleUpdateResponse(UUID id) {
        var u = sampleUpdateDto();
        return new EventTypeResponseDto(
                id,
                categoryResponse(categoryId),
                u.name(),
                u.description(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public Class<EventTypeResponseDto> responseDtoClass() {
        return EventTypeResponseDto.class;
    }

    // Convenience variants used across tests
    public static class Wedding extends EventTypeBuilder {
        @Override
        public EventType sampleEntity() {
            return EventType.builder()
                    .eventCategory(new EventCategoryBuilder.Social().sampleEntity())
                    .name("Wedding")
                    .description("Wedding ceremonies and receptions")
                    .iconUrl("https://cdn.ivyinc.com/icons/wedding.png")
                    .isActive(true)
                    .build();
        }
        @Override
        public EventTypeCreateDto sampleCreateDto() {
            return new EventTypeCreateDto(UUID.randomUUID(), "Wedding", "Wedding ceremonies and receptions");
        }
        @Override
        public EventTypeUpdateDto sampleUpdateDto() {
            return new EventTypeUpdateDto(UUID.randomUUID(), "Wedding (Updated)", "Updated - weddings");
        }
    }

    public static class TeamBuilding extends EventTypeBuilder {
        @Override
        public EventType sampleEntity() {
            return EventType.builder()
                    .eventCategory(new EventCategoryBuilder.Corporate().sampleEntity())
                    .name("Team Building")
                    .description("Corporate team building activities")
                    .iconUrl("https://cdn.ivyinc.com/icons/team-building.png")
                    .isActive(true)
                    .build();
        }
        @Override
        public EventTypeCreateDto sampleCreateDto() {
            return new EventTypeCreateDto(UUID.randomUUID(), "Team Building", "Corporate team building activities");
        }
        @Override
        public EventTypeUpdateDto sampleUpdateDto() {
            return new EventTypeUpdateDto(UUID.randomUUID(), "Team Building (Updated)", "Updated - team events");
        }
    }
}
