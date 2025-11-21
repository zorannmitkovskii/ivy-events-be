package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ExpenseResponseDto(UUID id,
                                 BudgetResponseDto budget,
                                 String name,
                                 String description,
                                 BigDecimal amount,
                                 LocalDateTime dueDate,
                                 String paymentStatus,
                                 String paymentMethod,
                                 String receiptUrl,
                                 LocalDateTime createdAt,
                                 LocalDateTime updatedAt) implements BaseResponseDto {
}
