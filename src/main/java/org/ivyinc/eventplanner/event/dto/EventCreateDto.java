package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventCreateDto(
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
        String notificationType,
        String uniqueUrl,
        String coverImageUrl,
        String timezone,
        String status,
        String visibility,
        UUID createdBy,
        UUID lastUpdatedBy
) implements BaseCreateRequestDto {
}
