package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;

import java.math.BigDecimal;

public record BudgetUpdateDto(
        String eventId,
        String name,
        String description,
        BigDecimal amount,
        BigDecimal remainAmount
) implements BaseUpdateRequestDto {
}
