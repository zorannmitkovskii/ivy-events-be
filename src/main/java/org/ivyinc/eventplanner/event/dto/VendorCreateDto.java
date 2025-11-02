package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.util.List;

public record VendorCreateDto(
        String name,
        String vendorType,
        ContactCreateDto contact,
        String website,
        String instagramUrl,
        Double rating,
        Boolean isActive,
        List<PackageCreateDto> packages
) implements BaseCreateRequestDto {
}
