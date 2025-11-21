package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;
import org.ivyinc.eventplanner.event.enums.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventUpdateDto(
        UUID eventTypeId,
        UUID eventInfoId,
        UUID organizerId,
        String name,
        String description,
        UUID agendaId,
        Integer maxGuests,
        LocalDateTime startDate,
        LocalDateTime endDate,
        UUID locationId,
        UUID vendorId,
        NotificationType notificationType,
        String uniqueUrl,
        String coverImageUrl,
        String timezone,
        String status,
        String visibility,
        UUID createdBy,
        UUID lastUpdatedBy
) implements BaseUpdateRequestDto {
}
