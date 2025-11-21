package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;
import org.ivyinc.eventplanner.event.enums.FieldType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record FormFieldResponseDto(
        UUID id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String label,
        FieldType type,
        Integer orderIndex,
        boolean required,
        String placeholder,
        String validationRegex,
        List<FieldOptionResponseDto> options) implements BaseResponseDto {
}
