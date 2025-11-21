package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;

import java.util.List;

public record FormUpdateDto(
        String name,
        Integer version,
        List<FormFieldUpdateDto> fields
) implements BaseUpdateRequestDto {
}
