package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

public record VendorCreateDto(
        String name,
        String vendorType,
        ContactCreateDto contact,
        String website,
        String instagramUrl,
        Double rating,
        Boolean active
) implements BaseCreateRequestDto {
}
