package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;

import java.util.UUID;

public record EventTypeUpdateDto(
        UUID eventCategoryId,
        String name,
        String description
) implements BaseUpdateRequestDto {
}
