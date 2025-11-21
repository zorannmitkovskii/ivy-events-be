package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ExpenseCreateDto(
        UUID budgetId,
        String name,
        String description,
        BigDecimal amount,
        LocalDate dueDate,
        String paymentStatus,
        String paymentMethod,
        String receiptUrl
) implements BaseCreateRequestDto {
}
