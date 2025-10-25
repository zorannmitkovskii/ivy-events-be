package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.Expense;
import org.ivyinc.eventplanner.event.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService extends BaseService<Expense> {

    private ExpenseRepository expenseRepository;
    @Override
    protected BaseRepository<Expense> getRepository() {
        return expenseRepository;
    }
}
