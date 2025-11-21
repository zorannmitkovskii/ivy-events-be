package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;
import org.ivyinc.eventplanner.event.enums.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventResponseDto(
        UUID id,
        EventTypeResponseDto eventTypeResponseDto,
        EventInfoResponseDto eventInfoResponseDto,
        UUID organizerId,
        String name,
        String description,
        Integer maxGuests,
        LocalDateTime startDate,
        LocalDateTime endDate,
        LocationResponseDto locationResponseDto,
        VendorResponseDto vendorResponseDto,
        NotificationType notificationType,
        String uniqueUrl,
        String coverImageUrl,
        String timezone,
        String status,
        String visibility,
        UUID createdBy,
        UUID lastUpdatedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) implements BaseResponseDto {
}
