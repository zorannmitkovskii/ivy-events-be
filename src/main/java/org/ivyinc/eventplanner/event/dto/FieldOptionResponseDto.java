package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.util.UUID;

public record FieldOptionResponseDto(
        UUID id,
        String value,
        Integer orderIndex
) implements BaseCreateRequestDto {
}
