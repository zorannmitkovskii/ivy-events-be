package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.math.BigDecimal;

public record BudgetCreateDto(
        String name,
        String description,
        BigDecimal amount
) implements BaseCreateRequestDto {
}
