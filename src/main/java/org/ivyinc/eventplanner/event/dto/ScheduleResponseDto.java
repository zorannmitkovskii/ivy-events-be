package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ScheduleResponseDto(
        UUID id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        UUID eventId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer orderIndex,
        String description
) implements BaseResponseDto {
}
