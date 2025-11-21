package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentResponseDto(
        UUID id,
        String eventId,
        BigDecimal amount,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) implements BaseResponseDto {
}
