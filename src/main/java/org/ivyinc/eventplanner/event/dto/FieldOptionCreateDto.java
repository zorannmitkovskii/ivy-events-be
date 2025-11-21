package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

public record FieldOptionCreateDto(
        String value,
        int orderIndex
) implements BaseCreateRequestDto {
}
