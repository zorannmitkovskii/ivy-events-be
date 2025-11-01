package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.util.UUID;

public record EventTypeCreateDto(
        UUID eventCategoryId,
        String name,
        String description
) implements BaseCreateRequestDto {
}
