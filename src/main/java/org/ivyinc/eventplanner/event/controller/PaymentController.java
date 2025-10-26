package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.Payment;
import org.ivyinc.eventplanner.event.service.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/events")
public class PaymentController implements BaseController<Payment, PaymentService> {

    private final PaymentService paymentService;

    @Override
    public PaymentService getService() {
        return paymentService;
    }

}