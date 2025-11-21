package org.ivyinc.eventplanner.event.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ExpenseUpdateDto(
        UUID budgetId,
        String name,
        String description,
        BigDecimal amount,
        LocalDateTime dueDate,
        String paymentStatus,
        String paymentMethod,
        String receiptUrl
) {
}
