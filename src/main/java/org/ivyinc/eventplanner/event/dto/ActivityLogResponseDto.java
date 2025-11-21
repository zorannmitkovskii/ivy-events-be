package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ActivityLogResponseDto(
        UUID id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) implements BaseResponseDto {
}
