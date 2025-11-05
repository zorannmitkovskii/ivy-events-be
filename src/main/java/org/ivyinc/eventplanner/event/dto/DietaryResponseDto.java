package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.util.UUID;

public record DietaryResponseDto(
        UUID id,
        String name,
        String description
) implements BaseResponseDto {
}
