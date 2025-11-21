package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;
import org.ivyinc.eventplanner.event.enums.FieldType;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public record FormFieldCreateDto(
        String label,
        FieldType type,
        Integer orderIndex,
        boolean required,
        String placeholder,
        String validationRegex,
        List<FieldOptionCreateDto> options
) implements BaseCreateRequestDto {
}
