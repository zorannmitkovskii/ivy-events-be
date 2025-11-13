package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ScheduleUpdateDto(
        UUID eventId,
        UUID locationId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer orderIndex,
        String description
) implements BaseUpdateRequestDto {
}
