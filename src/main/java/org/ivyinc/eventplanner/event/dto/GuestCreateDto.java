package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;
import org.ivyinc.eventplanner.event.enums.InviteStatus;
import org.ivyinc.eventplanner.event.enums.NotificationType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record GuestCreateDto(UUID eventId,
                             List<String> names,
                             String note,
                             ContactCreateDto contact,
                             String tableNumber,
                             DietaryCreateDto dietaryPreferences,
                             UUID contactId,
                             NotificationType notificationType,
                             InviteStatus inviteStatus,
                             Integer numOfGuests,
                             LocalDateTime rsvpDate,
                             Boolean isVip,
                             Boolean checkInStatus) implements BaseCreateRequestDto {
}
