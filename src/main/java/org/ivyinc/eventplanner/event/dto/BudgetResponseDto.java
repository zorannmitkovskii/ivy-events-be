package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.math.BigDecimal;
import java.util.UUID;

public record BudgetResponseDto(
        UUID id,
        String eventId,
        String name,
        String description,
        BigDecimal amount,
        BigDecimal remainAmount
) implements BaseResponseDto {
}
