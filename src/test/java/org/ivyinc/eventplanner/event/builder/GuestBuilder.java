package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.enums.InviteStatus;
import org.ivyinc.eventplanner.event.enums.NotificationType;
import org.ivyinc.eventplanner.event.model.Guest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public abstract class GuestBuilder implements DtoBuilder<
        Guest,
        GuestCreateDto,
        GuestUpdateDto,
        GuestResponseDto
        > {

    UUID eventId = UUID.randomUUID();
    UUID contactId = UUID.randomUUID();

    ContactBuilder.WeddingContact weddingContactBuilder = new ContactBuilder.WeddingContact();
    ContactBuilder.TeamBuildingContact teamBuildingContactBuilder = new ContactBuilder.TeamBuildingContact();
    EventBuilder.Wedding wedding = new EventBuilder.Wedding();
    EventBuilder.TeamBuilding teamBuilding = new EventBuilder.TeamBuilding();
    DietaryBuilder dietaryBuilder = new DietaryBuilder();

    @Override
    public Class<GuestResponseDto> responseDtoClass() {
        return GuestResponseDto.class;
    }

    // ===== Concrete Builders =====
    public static class WeddingGuest1 extends GuestBuilder {

        @Override
        public Guest sampleEntity() {
            return Guest.builder()
                    .name("John Doe")
                    .note("Bride’s cousin")
                    .contact(weddingContactBuilder.sampleEntity())
                    .tableNumber("A1")
                    .dieatary(dietaryBuilder.sampleDietary())
                    .isVip(true)
                    .numOfGuests(2)
                    .rsvpDate(LocalDateTime.now().minusDays(5))
                    .checkInStatus(false)
                    .inviteStatus(InviteStatus.CONFIRMED)
                    .notificationType(NotificationType.EMAIL)
                    .build();
        }

        @Override
        public GuestCreateDto sampleCreateDto() {
            return new GuestCreateDto(
                    eventId,
                    List.of("John Doe"),
                    "Bride’s cousin",
                    weddingContactBuilder.sampleCreateDto(),
                    "A1",
                    dietaryBuilder.sampleCreateDto(),
                    contactId,
                    NotificationType.EMAIL,
                    InviteStatus.CONFIRMED,
                    2,
                    LocalDateTime.now().minusDays(5),
                    true,
                    false
            );
        }

        @Override
        public GuestUpdateDto sampleUpdateDto() {
            return new GuestUpdateDto(
                    eventId,
                    List.of("Jane Doe"),
                    "Updated note",
                    teamBuildingContactBuilder.sampleUpdateDto(),
                    "A2",
                    dietaryBuilder.sampleUpdateDto(),
                    contactId,
                    NotificationType.SMS,
                    InviteStatus.CONFIRMED,
                    3,
                    LocalDateTime.now(),
                    true,
                    true
            );
        }

        @Override
        public GuestResponseDto sampleCreateResponse(UUID id) {
            return new GuestResponseDto(
                    id,
                    eventId,
                    "John Doe",
                    "Bride’s cousin",
                    "A1",
                    dietaryBuilder.sampleCreateResponse(UUID.randomUUID()),
                    contactId,
                    NotificationType.EMAIL,
                    InviteStatus.CONFIRMED,
                    LocalDateTime.now().minusDays(5),
                    true,
                    false,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public GuestResponseDto sampleUpdateResponse(UUID id) {
            return new GuestResponseDto(
                    id,
                    eventId,
                    "John Doe",
                    "Updated note",
                    "A2",
                    dietaryBuilder.sampleUpdateResponse(UUID.randomUUID()),
                    contactId,
                    NotificationType.SMS,
                    InviteStatus.CONFIRMED,
                    LocalDateTime.now(),
                    true,
                    true,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }

    // ---------------------------------------------------------------

    public static class WeddingGuest2 extends GuestBuilder {

        @Override
        public Guest sampleEntity() {
            return Guest.builder()
                    .name("Maria Petrova")
                    .note("Groom’s coworker")
                    .tableNumber("B3")
                    .dieatary(dietaryBuilder.sampleDietary())
                    .isVip(false)
                    .numOfGuests(1)
                    .rsvpDate(LocalDateTime.now().minusDays(10))
                    .checkInStatus(false)
                    .inviteStatus(InviteStatus.PENDING)
                    .notificationType(NotificationType.EMAIL)
                    .build();
        }

        @Override
        public GuestCreateDto sampleCreateDto() {
            return new GuestCreateDto(
                    UUID.randomUUID(),
                    List.of("Maria Petrov"),
                    "Groom’s coworker",
                    weddingContactBuilder.sampleCreateDto(),
                    "B3",
                    dietaryBuilder.sampleCreateDto(),
                    UUID.randomUUID(),
                    NotificationType.EMAIL,
                    InviteStatus.PENDING,
                    1,
                    LocalDateTime.now().minusDays(10),
                    false,
                    false
            );
        }

        @Override
        public GuestUpdateDto sampleUpdateDto() {
            return new GuestUpdateDto(
                    eventId,
                    List.of("Maria Petrova"),
                    "Updated dietary needs",
                    weddingContactBuilder.sampleUpdateDto(),
                    "B4",
                    dietaryBuilder.sampleUpdateDto(),
                    contactId,
                    NotificationType.EMAIL,
                    InviteStatus.CONFIRMED,
                    1,
                    LocalDateTime.now(),
                    false,
                    true
            );
        }

        @Override
        public GuestResponseDto sampleCreateResponse(UUID id) {
            return new GuestResponseDto(
                    id,
                    eventId,
                    "Maria Petrova",
                    "Groom’s coworker",
                    "B3",
                    dietaryBuilder.sampleCreateResponse(UUID.randomUUID()),
                    contactId,
                    NotificationType.EMAIL,
                    InviteStatus.PENDING,
                    LocalDateTime.now().minusDays(10),
                    false,
                    false,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public GuestResponseDto sampleUpdateResponse(UUID id) {
            return new GuestResponseDto(
                    id,
                    eventId,
                    "Maria Petrova",
                    "Updated dietary needs",
                    "B4",
                    dietaryBuilder.sampleUpdateResponse(UUID.randomUUID()),
                    contactId,
                    NotificationType.EMAIL,
                    InviteStatus.CONFIRMED,
                    LocalDateTime.now(),
                    false,
                    true,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }

    // ---------------------------------------------------------------

    public static class TeamBuildingGuest extends GuestBuilder {

        @Override
        public Guest sampleEntity() {
            return Guest.builder()
                    .name("Team Member 1")
                    .note("HR Department")
                    .contact(teamBuildingContactBuilder.sampleEntity())
                    .tableNumber("T1")
                    .dieatary(dietaryBuilder.sampleDietary())
                    .isVip(false)
                    .numOfGuests(1)
                    .rsvpDate(LocalDateTime.now().minusDays(2))
                    .checkInStatus(false)
                    .inviteStatus(InviteStatus.CONFIRMED)
                    .notificationType(NotificationType.EMAIL)
                    .build();
        }

        @Override
        public GuestCreateDto sampleCreateDto() {
            return new GuestCreateDto(
                    eventId,
                    List.of("Team Member 1"),
                    "HR Department",
                    teamBuildingContactBuilder.sampleCreateDto(),
                    "T1",
                    dietaryBuilder.sampleCreateDto(),
                    contactId,
                    NotificationType.EMAIL,
                    InviteStatus.CONFIRMED,
                    1,
                    LocalDateTime.now().minusDays(2),
                    false,
                    false
            );
        }

        @Override
        public GuestUpdateDto sampleUpdateDto() {
            return new GuestUpdateDto(
                    eventId,
                    List.of("Team Member 1"),
                    "Updated note team",
                    teamBuildingContactBuilder.sampleUpdateDto(),
                    "T2",
                    dietaryBuilder.sampleUpdateDto(),
                    contactId,
                    NotificationType.SMS,
                    InviteStatus.CONFIRMED,
                    1,
                    LocalDateTime.now(),
                    false,
                    true
            );
        }

        @Override
        public GuestResponseDto sampleCreateResponse(UUID id) {
            return new GuestResponseDto(
                    id,
                    eventId,
                    "Team Member 1",
                    "HR Department",
                    "T1",
                    dietaryBuilder.sampleCreateResponse(UUID.randomUUID()),
                    contactId,
                    NotificationType.EMAIL,
                    InviteStatus.CONFIRMED,
                    LocalDateTime.now().minusDays(2),
                    false,
                    false,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public GuestResponseDto sampleUpdateResponse(UUID id) {
            return new GuestResponseDto(
                    id,
                    eventId,
                    "Team Member 1",
                    "Updated note team",
                    "T2",
                    dietaryBuilder.sampleUpdateResponse(UUID.randomUUID()),
                    contactId,
                    NotificationType.SMS,
                    InviteStatus.CONFIRMED,
                    LocalDateTime.now(),
                    false,
                    true,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }
}

