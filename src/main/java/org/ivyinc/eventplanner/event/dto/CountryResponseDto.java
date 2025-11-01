package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.util.UUID;

public record CountryResponseDto(
        UUID id,
        String iso2,
        String iso3,
        String countryName,
        String flag
) implements BaseResponseDto {
}
