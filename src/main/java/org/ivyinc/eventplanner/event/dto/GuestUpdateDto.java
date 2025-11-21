package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;
import org.ivyinc.eventplanner.event.enums.InviteStatus;
import org.ivyinc.eventplanner.event.enums.NotificationType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record GuestUpdateDto(UUID eventId,
                             List<String> names,
                             String note,
                             ContactUpdateDto contact,
                             String tableNumber,
                             DietaryUpdateDto dieatary,
                             UUID contactId,
                             NotificationType notificationType,
                             InviteStatus inviteStatus,
                             Integer numOfGuests,
                             LocalDateTime rsvpDate,
                             Boolean isVip,
                             Boolean checkInStatus) implements BaseCreateRequestDto {
}
