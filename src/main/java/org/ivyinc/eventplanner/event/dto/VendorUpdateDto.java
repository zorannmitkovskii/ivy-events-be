package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;
import org.ivyinc.eventplanner.event.enums.VendorType;
import org.ivyinc.eventplanner.event.enums.AvailabilityStatus;

import java.util.UUID;

public record VendorUpdateDto(
        String name,
        VendorType type,
        UUID contactId,
        String website,
        String instagramUrl,
        String serviceArea,
        AvailabilityStatus availabilityStatus,
        String contractUrl,
        Double rating,
        Boolean isActive
) implements BaseUpdateRequestDto {
}
