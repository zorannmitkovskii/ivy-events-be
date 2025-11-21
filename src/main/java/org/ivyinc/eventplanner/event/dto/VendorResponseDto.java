package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;
import org.ivyinc.eventplanner.event.enums.VendorType;
import org.ivyinc.eventplanner.event.enums.AvailabilityStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record VendorResponseDto(
        UUID id,
        String name,
        VendorType type,
        ContactResponseDto contact,
        String website,
        String instagramUrl,
        String serviceArea,
        AvailabilityStatus availabilityStatus,
        String contractUrl,
        Double rating,
        Boolean isActive,
        List<PackageResponseDto> packages,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) implements BaseResponseDto {
}
