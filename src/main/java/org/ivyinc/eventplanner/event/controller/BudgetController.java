package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.Budget;
import org.ivyinc.eventplanner.event.service.BudgetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/budgets")
public class BudgetController implements BaseController<Budget, BudgetService> {
    private BudgetService budgetService;
    @Override
    public BudgetService getService() {
        return budgetService;
    }
}
