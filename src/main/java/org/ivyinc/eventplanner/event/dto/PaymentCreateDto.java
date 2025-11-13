package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.math.BigDecimal;

public record PaymentCreateDto(
        String eventId,
        BigDecimal amount,
        String status
) implements BaseCreateRequestDto {
}
