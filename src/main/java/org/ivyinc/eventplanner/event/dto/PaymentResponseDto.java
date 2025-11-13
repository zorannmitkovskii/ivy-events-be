package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentResponseDto(
        UUID id,
        String eventId,
        BigDecimal amount,
        String status
) implements BaseResponseDto {
}
