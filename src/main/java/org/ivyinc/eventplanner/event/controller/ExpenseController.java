package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.ExpenseCreateDto;
import org.ivyinc.eventplanner.event.dto.ExpenseResponseDto;
import org.ivyinc.eventplanner.event.dto.ExpenseUpdateDto;
import org.ivyinc.eventplanner.event.model.Expense;
import org.ivyinc.eventplanner.event.service.ExpenseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/expenses")
public class ExpenseController implements BaseController<Expense, ExpenseCreateDto, ExpenseUpdateDto, ExpenseResponseDto> {

    private final ExpenseService expenseService;

    @Override
    public ExpenseService getService() {
        return expenseService;
    }
}
