package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;

public record VendorUpdateDto(
        String name,
        String vendorType,
        ContactUpdateDto contact,
        String website,
        String instagramUrl,
        Double rating,
        Boolean active
) implements BaseUpdateRequestDto {
}
