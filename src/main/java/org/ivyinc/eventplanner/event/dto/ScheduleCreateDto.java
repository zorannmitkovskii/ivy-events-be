package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ScheduleCreateDto(
        UUID eventId,
        UUID locationId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer orderIndex,
        String description
) implements BaseCreateRequestDto {
}
