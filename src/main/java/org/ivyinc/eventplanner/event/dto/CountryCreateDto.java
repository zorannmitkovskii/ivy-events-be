package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

public record CountryCreateDto(
        String iso2,
        String iso3,
        String countryName,
        String flag
) implements BaseCreateRequestDto {
}
