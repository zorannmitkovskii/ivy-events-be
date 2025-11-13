package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.PaymentCreateDto;
import org.ivyinc.eventplanner.event.dto.PaymentResponseDto;
import org.ivyinc.eventplanner.event.dto.PaymentUpdateDto;
import org.ivyinc.eventplanner.event.mapper.PaymentMapper;
import org.ivyinc.eventplanner.event.model.Payment;
import org.ivyinc.eventplanner.event.repository.PaymentRepository;
import org.springframework.stereotype.Service;


@Service
public class PaymentService extends BaseServiceImpl<Payment, PaymentCreateDto, PaymentUpdateDto, PaymentResponseDto, PaymentRepository> {
    public PaymentService(PaymentRepository repository, PaymentMapper mapper) {
        super(repository, mapper);
    }
}
