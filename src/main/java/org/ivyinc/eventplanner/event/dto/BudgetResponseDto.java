package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record BudgetResponseDto(
        UUID id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String eventId,
        String name,
        String description,
        BigDecimal amount,
        BigDecimal remainAmount
) implements BaseResponseDto {
}
