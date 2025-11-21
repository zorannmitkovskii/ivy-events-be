package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;
import org.ivyinc.eventplanner.event.enums.InviteStatus;
import org.ivyinc.eventplanner.event.enums.NotificationType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record GuestResponseDto(UUID id,
                               UUID eventId,
                               String name,
                               String note,
                               String tableNumber,
                               DietaryResponseDto dietaryPreferences,
                               UUID contactId,
                               NotificationType notificationType,
                               InviteStatus inviteStatus,
                               LocalDateTime rsvpDate,
                               Boolean isVip,
                               Boolean checkInStatus,
                               LocalDateTime createdAt,
                               LocalDateTime updatedAt) implements BaseResponseDto {
}
