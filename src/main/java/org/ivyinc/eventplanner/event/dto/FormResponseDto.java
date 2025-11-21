package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record FormResponseDto(
        UUID id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String name,
        Integer version,
        List<FormFieldResponseDto> fields) implements BaseResponseDto {

}
