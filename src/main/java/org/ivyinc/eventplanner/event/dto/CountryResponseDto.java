package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CountryResponseDto(
        UUID id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String iso2,
        String iso3,
        String countryName,
        String flag
) implements BaseResponseDto {
}
