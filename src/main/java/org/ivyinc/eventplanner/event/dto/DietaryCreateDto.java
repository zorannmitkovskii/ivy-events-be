package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

public record DietaryCreateDto(
        String name,
        String description
) implements BaseCreateRequestDto {
}
