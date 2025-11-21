package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.PaymentCreateDto;
import org.ivyinc.eventplanner.event.dto.PaymentResponseDto;
import org.ivyinc.eventplanner.event.dto.PaymentUpdateDto;
import org.ivyinc.eventplanner.event.model.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentBuilder implements DtoBuilder<
        Payment,
        PaymentCreateDto,
        PaymentUpdateDto,
        PaymentResponseDto
        > {

    private final String sampleEventId = UUID.randomUUID().toString();

    @Override
    public Payment sampleEntity() {
        return Payment.builder()
                .eventId(sampleEventId)
                .amount(1500.00)
                .status("PENDING")
                .build();
    }

    @Override
    public PaymentCreateDto sampleCreateDto() {
        return new PaymentCreateDto(
                sampleEventId,
                BigDecimal.valueOf(1500.00),
                "PENDING"
        );
    }

    @Override
    public PaymentUpdateDto sampleUpdateDto() {
        return new PaymentUpdateDto(
                sampleEventId,
                BigDecimal.valueOf(2000.00),
                "PAID"
        );
    }

    @Override
    public PaymentResponseDto sampleCreateResponse(UUID id) {
        return new PaymentResponseDto(
                id,
                sampleEventId,
                BigDecimal.valueOf(1500.00),
                "PENDING",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public PaymentResponseDto sampleUpdateResponse(UUID id) {
        return new PaymentResponseDto(
                id,
                sampleEventId,
                BigDecimal.valueOf(2000.00),
                "PAID",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public Class<PaymentResponseDto> responseDtoClass() {
        return PaymentResponseDto.class;
    }
}

