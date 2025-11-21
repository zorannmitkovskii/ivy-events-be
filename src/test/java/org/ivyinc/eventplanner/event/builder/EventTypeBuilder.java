package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.model.EventCategory;
import org.ivyinc.eventplanner.event.model.EventType;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class EventTypeBuilder implements DtoBuilder<EventType, EventTypeCreateDto, EventTypeUpdateDto, EventTypeResponseDto> {

    UUID corporateCategoryId = UUID.randomUUID();
    UUID socialCategoryId = UUID.randomUUID();
    EventCategoryBuilder.Corporate corporateBuilder = new EventCategoryBuilder.Corporate();
    EventCategoryBuilder.Social socialBuilder = new EventCategoryBuilder.Social();
    EventCategory corporateCategory = corporateBuilder.sampleEntity();
    EventCategoryResponseDto corporateCategoryCreateResponseDto = corporateBuilder.sampleCreateResponse(corporateCategoryId);
    EventCategoryResponseDto socialCategoryCreateResponseDto = socialBuilder.sampleCreateResponse(socialCategoryId);
    EventCategoryResponseDto corporateCategoryUpdateResponseDto = corporateBuilder.sampleUpdateResponse(corporateCategoryId);
    EventCategoryResponseDto socialCategoryUpdateResponseDto = socialBuilder.sampleUpdateResponse(socialCategoryId);
    EventCategory socialCategory = socialBuilder.sampleEntity();

    // ----------- Abstract methods that subclasses override -----------

    @Override
    public abstract EventType sampleEntity();

    @Override
    public abstract EventTypeCreateDto sampleCreateDto();

    @Override
    public abstract EventTypeUpdateDto sampleUpdateDto();

    @Override
    public abstract EventTypeResponseDto sampleCreateResponse(UUID id);

    @Override
    public abstract EventTypeResponseDto sampleUpdateResponse(UUID id);

    @Override
    public Class<EventTypeResponseDto> responseDtoClass() {
        return EventTypeResponseDto.class;
    }

    // ================================================================
    // 🏢 CORPORATE → TEAM BUILDING
    // ================================================================
    public static class TeamBuilding extends EventTypeBuilder {

        @Override
        public EventType sampleEntity() {
            return EventType.builder()
                    .eventCategory(corporateCategory)
                    .name("Team Building")
                    .description("Activities designed to strengthen collaboration and trust among employees.")
                    .build();
        }

        @Override
        public EventTypeCreateDto sampleCreateDto() {
            return new EventTypeCreateDto(
                    corporateCategoryId,
                    "Team Building",
                    "Activities designed to strengthen collaboration and trust among employees."
            );
        }

        @Override
        public EventTypeUpdateDto sampleUpdateDto() {
            return new EventTypeUpdateDto(
                    corporateCategoryId,
                    "Updated Team Building",
                    "Updated description for team-building events."
            );
        }

        @Override
        public EventTypeResponseDto sampleCreateResponse(UUID id) {
            return new EventTypeResponseDto(
                    id,
                    corporateCategoryCreateResponseDto,
                    "Team Building",
                    "Activities designed to strengthen collaboration and trust among employees.",
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public EventTypeResponseDto sampleUpdateResponse(UUID id) {
            return new EventTypeResponseDto(
                    id,
                    corporateCategoryUpdateResponseDto,
                    "Updated Team Building",
                    "Updated description for team-building events.",
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }

    // ================================================================
    // 💍 SOCIAL → WEDDING
    // ================================================================
    public static class Wedding extends EventTypeBuilder {

        @Override
        public EventType sampleEntity() {
            return EventType.builder()
                    .eventCategory(socialCategory)
                    .name("Wedding")
                    .description("A special ceremony celebrating the union of two people.")
                    .build();
        }

        @Override
        public EventTypeCreateDto sampleCreateDto() {
            return new EventTypeCreateDto(
                    socialCategoryId,
                    "Wedding",
                    "A special ceremony celebrating the union of two people."
            );
        }

        @Override
        public EventTypeUpdateDto sampleUpdateDto() {
            return new EventTypeUpdateDto(
                    socialCategoryId,
                    "Updated Wedding",
                    "Updated description for wedding event type."
            );
        }

        @Override
        public EventTypeResponseDto sampleCreateResponse(UUID id) {
            return new EventTypeResponseDto(
                    id,
                    socialCategoryCreateResponseDto,
                    "Wedding",
                    "A special ceremony celebrating the union of two people.",
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public EventTypeResponseDto sampleUpdateResponse(UUID id) {
            return new EventTypeResponseDto(
                    id,
                    socialCategoryUpdateResponseDto,
                    "Updated Wedding",
                    "Updated description for wedding event type.",
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }
}
