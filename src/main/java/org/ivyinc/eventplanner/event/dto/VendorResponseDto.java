package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.util.List;
import java.util.UUID;

public record VendorResponseDto(
        UUID id,
        String name,
        String vendorType,
        ContactResponseDto contact,
        String website,
        String instagramUrl,
        Double rating,
        Boolean active,
        List<PackageResponseDto> packages
) implements BaseResponseDto {
}
