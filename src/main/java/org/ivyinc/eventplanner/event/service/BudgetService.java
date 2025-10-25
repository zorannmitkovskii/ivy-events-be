package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.Budget;
import org.ivyinc.eventplanner.event.repository.BudgetRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BudgetService extends BaseService<Budget> {
    private BudgetRepository budgetRepository;

    @Override
    protected JpaRepository getRepository() {
        return budgetRepository;
    }
}
