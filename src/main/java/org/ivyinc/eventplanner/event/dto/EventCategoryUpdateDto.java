package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;


public record EventCategoryUpdateDto(
        String name,
        String description
) implements BaseUpdateRequestDto {
}
