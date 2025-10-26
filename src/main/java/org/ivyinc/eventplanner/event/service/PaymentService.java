package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.Payment;
import org.ivyinc.eventplanner.event.repository.PaymentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService extends BaseService<Payment> {

    private PaymentRepository paymentRepository;

    @Override
    protected JpaRepository<Payment, Long> getRepository() {
        return paymentRepository;
    }
}
