package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;
import org.ivyinc.eventplanner.event.enums.FieldType;

import java.util.List;
import java.util.UUID;

public record FormFieldUpdateDto(
        UUID formId,
        String label,
        FieldType type,
        Integer orderIndex,
        Boolean required,
        String placeholder,
        String validationRegex,
        List<FieldOptionUpdateDto> options
) implements BaseUpdateRequestDto {
}
