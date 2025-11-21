package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.model.Event;
import org.ivyinc.eventplanner.event.model.EventType;
import org.ivyinc.eventplanner.event.enums.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class EventBuilder implements DtoBuilder<Event, EventCreateDto, EventUpdateDto, EventResponseDto> {

    // ================================================================
    // Reusable shared test data (same pattern as EventTypeBuilder)
    // ================================================================

    UUID weddingTypeId = UUID.randomUUID();
    UUID teamBuildingTypeId = UUID.randomUUID();

    EventTypeBuilder.Wedding weddingTypeBuilder = new EventTypeBuilder.Wedding();
    EventTypeBuilder.TeamBuilding teamBuildingTypeBuilder = new EventTypeBuilder.TeamBuilding();

    LocationBuilder.WeddingVenue weddingLocation = new LocationBuilder.WeddingVenue();
    LocationBuilder.TeamBuildingResort teamBuildingLocation = new LocationBuilder.TeamBuildingResort();

    VendorBuilder.WeddingVendor weddingVendor = new VendorBuilder.WeddingVendor();
    VendorBuilder.TeamBuildingVendor teamBuildingVendor = new VendorBuilder.TeamBuildingVendor();

    EventType weddingType = weddingTypeBuilder.sampleEntity();
    EventType teamBuildingType = teamBuildingTypeBuilder.sampleEntity();

    EventTypeResponseDto weddingTypeCreateResponse = weddingTypeBuilder.sampleCreateResponse(weddingTypeId);
    EventTypeResponseDto teamBuildingTypeCreateResponse = teamBuildingTypeBuilder.sampleCreateResponse(teamBuildingTypeId);

    EventTypeResponseDto weddingTypeUpdateResponse = weddingTypeBuilder.sampleUpdateResponse(weddingTypeId);
    EventTypeResponseDto teamBuildingTypeUpdateResponse = teamBuildingTypeBuilder.sampleUpdateResponse(teamBuildingTypeId);

    UUID organizerId = UUID.randomUUID();
    UUID agendaId = UUID.randomUUID();
    UUID locationId = UUID.randomUUID();
    UUID vendorId = UUID.randomUUID();
    UUID eventInfoId = UUID.randomUUID();

    // ================================================================
    // Abstract methods to be implemented by subclasses
    // ================================================================
    @Override
    public abstract Event sampleEntity();

    @Override
    public abstract EventCreateDto sampleCreateDto();

    @Override
    public abstract EventUpdateDto sampleUpdateDto();

    @Override
    public abstract EventResponseDto sampleCreateResponse(UUID id);

    @Override
    public abstract EventResponseDto sampleUpdateResponse(UUID id);

    @Override
    public Class<EventResponseDto> responseDtoClass() {
        return EventResponseDto.class;
    }

    // ================================================================
    // 🏢 CORPORATE → TEAM BUILDING EVENT
    // ================================================================
    public static class TeamBuilding extends EventBuilder {

        @Override
        public Event sampleEntity() {
            return Event.builder()
                    .eventType(teamBuildingType)
                    .name("Team Building Retreat")
                    .description("Outdoor activities to boost team cohesion.")
                    .maxGuests(80)
                    .startDate(LocalDateTime.of(2025, 4, 5, 10, 0))
                    .endDate(LocalDateTime.of(2025, 4, 5, 18, 0))
                    .location(weddingLocation.sampleEntity())
                    .vendor(weddingVendor.sampleEntity())
                    .notificationType(NotificationType.EMAIL)
                    .publicCode("team-2025-01")
                    .coverImageUrl("https://cdn.ivyinc.com/team-building.jpg")
                    .timezone("Europe/Skopje")
                    .status("ACTIVE")
                    .visibility("PRIVATE")
                    .createdBy(organizerId)
                    .lastUpdatedBy(organizerId)
                    .build();
        }

        @Override
        public EventCreateDto sampleCreateDto() {
            return new EventCreateDto(
                    teamBuildingTypeId,
                    eventInfoId,
                    organizerId,
                    "Team Building Retreat",
                    "Outdoor activities to boost team cohesion.",
                    agendaId,
                    80,
                    LocalDateTime.of(2025, 4, 5, 10, 0),
                    LocalDateTime.of(2025, 4, 5, 18, 0),
                    locationId,
                    vendorId,
                    NotificationType.EMAIL,
                    "team-2025-01",
                    "https://cdn.ivyinc.com/team-building.jpg",
                    "Europe/Skopje",
                    "ACTIVE",
                    "PRIVATE",
                    organizerId,
                    organizerId
            );
        }

        @Override
        public EventUpdateDto sampleUpdateDto() {
            return new EventUpdateDto(
                    teamBuildingTypeId,
                    eventInfoId,
                    organizerId,
                    "Updated Team Building Retreat",
                    "Updated description for team building.",
                    agendaId,
                    100,
                    LocalDateTime.of(2025, 4, 6, 10, 0),
                    LocalDateTime.of(2025, 4, 6, 18, 0),
                    locationId,
                    vendorId,
                    NotificationType.EMAIL,
                    "team-2025-02",
                    "https://cdn.ivyinc.com/team-building-updated.jpg",
                    "Europe/Skopje",
                    "ACTIVE",
                    "PRIVATE",
                    organizerId,
                    organizerId
            );
        }

        @Override
        public EventResponseDto sampleCreateResponse(UUID id) {
            return new EventResponseDto(
                    id,
                    teamBuildingTypeCreateResponse,
                    null, // event info dto
                    organizerId,
                    "Team Building Retreat",
                    "Outdoor activities to boost team cohesion.",
                    80,
                    LocalDateTime.of(2025, 4, 5, 10, 0),
                    LocalDateTime.of(2025, 4, 5, 18, 0),
                    null,
                    null,
                    NotificationType.EMAIL,
                    "team-2025-01",
                    "https://cdn.ivyinc.com/team-building.jpg",
                    "Europe/Skopje",
                    "ACTIVE",
                    "PRIVATE",
                    organizerId,
                    organizerId,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public EventResponseDto sampleUpdateResponse(UUID id) {
            return new EventResponseDto(
                    id,
                    teamBuildingTypeUpdateResponse,
                    null,
                    organizerId,
                    "Updated Team Building Retreat",
                    "Updated description for team building.",
                    100,
                    LocalDateTime.of(2025, 4, 6, 10, 0),
                    LocalDateTime.of(2025, 4, 6, 18, 0),
                    null,
                    null,
                    NotificationType.EMAIL,
                    "team-2025-02",
                    "https://cdn.ivyinc.com/team-building-updated.jpg",
                    "Europe/Skopje",
                    "ACTIVE",
                    "PRIVATE",
                    organizerId,
                    organizerId,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }

    // ================================================================
    // 💍 SOCIAL → WEDDING EVENT
    // ================================================================
    public static class Wedding extends EventBuilder {

        @Override
        public Event sampleEntity() {
            return Event.builder()
                    .eventType(weddingType)
                    .name("Classic Wedding Ceremony")
                    .description("A romantic wedding celebration.")
                    .maxGuests(150)
                    .startDate(LocalDateTime.of(2025, 9, 12, 15, 0))
                    .endDate(LocalDateTime.of(2025, 9, 12, 22, 0))
                    .location(teamBuildingLocation.sampleEntity())
                    .vendor(weddingVendor.sampleEntity())
                    .notificationType(NotificationType.EMAIL)
                    .publicCode("wedding-2025-01")
                    .coverImageUrl("https://cdn.ivyinc.com/wedding-cover.jpg")
                    .timezone("Europe/Skopje")
                    .status("ACTIVE")
                    .visibility("PUBLIC")
                    .createdBy(organizerId)
                    .lastUpdatedBy(organizerId)
                    .build();
        }

        @Override
        public EventCreateDto sampleCreateDto() {
            return new EventCreateDto(
                    weddingTypeId,
                    eventInfoId,
                    organizerId,
                    "Classic Wedding Ceremony",
                    "A romantic wedding celebration.",
                    agendaId,
                    150,
                    LocalDateTime.of(2025, 9, 12, 15, 0),
                    LocalDateTime.of(2025, 9, 12, 22, 0),
                    locationId,
                    vendorId,
                    NotificationType.EMAIL,
                    "wedding-2025-01",
                    "https://cdn.ivyinc.com/wedding-cover.jpg",
                    "Europe/Skopje",
                    "ACTIVE",
                    "PUBLIC",
                    organizerId,
                    organizerId
            );
        }

        @Override
        public EventUpdateDto sampleUpdateDto() {
            return new EventUpdateDto(
                    weddingTypeId,
                    eventInfoId,
                    organizerId,
                    "Updated Wedding Ceremony",
                    "Updated wedding description",
                    agendaId,
                    170,
                    LocalDateTime.of(2025, 9, 13, 15, 0),
                    LocalDateTime.of(2025, 9, 13, 22, 0),
                    locationId,
                    vendorId,
                    NotificationType.EMAIL,
                    "wedding-2025-02",
                    "https://cdn.ivyinc.com/wedding-cover-updated.jpg",
                    "Europe/Skopje",
                    "ACTIVE",
                    "PUBLIC",
                    organizerId,
                    organizerId
            );
        }

        @Override
        public EventResponseDto sampleCreateResponse(UUID id) {
            return new EventResponseDto(
                    id,
                    weddingTypeCreateResponse,
                    null,
                    organizerId,
                    "Classic Wedding Ceremony",
                    "A romantic wedding celebration.",
                    150,
                    LocalDateTime.of(2025, 9, 12, 15, 0),
                    LocalDateTime.of(2025, 9, 12, 22, 0),
                    null,
                    null,
                    NotificationType.EMAIL,
                    "wedding-2025-01",
                    "https://cdn.ivyinc.com/wedding-cover.jpg",
                    "Europe/Skopje",
                    "ACTIVE",
                    "PUBLIC",
                    organizerId,
                    organizerId,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public EventResponseDto sampleUpdateResponse(UUID id) {
            return new EventResponseDto(
                    id,
                    weddingTypeUpdateResponse,
                    null,
                    organizerId,
                    "Updated Wedding Ceremony",
                    "Updated wedding description",
                    170,
                    LocalDateTime.of(2025, 9, 13, 15, 0),
                    LocalDateTime.of(2025, 9, 13, 22, 0),
                    null,
                    null,
                    NotificationType.EMAIL,
                    "wedding-2025-02",
                    "https://cdn.ivyinc.com/wedding-cover-updated.jpg",
                    "Europe/Skopje",
                    "ACTIVE",
                    "PUBLIC",
                    organizerId,
                    organizerId,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }
}

