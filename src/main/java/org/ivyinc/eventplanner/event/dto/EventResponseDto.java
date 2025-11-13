package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;
import org.ivyinc.eventplanner.event.model.Contact;
import org.ivyinc.eventplanner.event.model.EventType;
import org.ivyinc.eventplanner.event.model.Location;
import org.ivyinc.eventplanner.event.model.Vendor;
import org.ivyinc.eventplanner.event.repository.VendorRepository;

import java.time.LocalDateTime;
import java.util.List;
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
        String notificationType,
        String uniqueUrl,
        String coverImageUrl,
        String timezone,
        String status,
        String visibility,
        UUID createdBy,
        UUID lastUpdatedBy
) implements BaseResponseDto {
}
