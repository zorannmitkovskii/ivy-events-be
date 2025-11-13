package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;

import java.math.BigDecimal;

public record PaymentUpdateDto(
        String eventId,
        BigDecimal amount,
        String status
) implements BaseUpdateRequestDto {
}
