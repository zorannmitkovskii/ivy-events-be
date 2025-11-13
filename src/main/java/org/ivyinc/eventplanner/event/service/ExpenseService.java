package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.ExpenseCreateDto;
import org.ivyinc.eventplanner.event.dto.ExpenseResponseDto;
import org.ivyinc.eventplanner.event.dto.ExpenseUpdateDto;
import org.ivyinc.eventplanner.event.mapper.ExpenseMapper;
import org.ivyinc.eventplanner.event.model.Expense;
import org.ivyinc.eventplanner.event.repository.ExpenseRepository;
import org.springframework.stereotype.Service;


@Service
public class ExpenseService extends BaseServiceImpl<Expense, ExpenseCreateDto, ExpenseUpdateDto, ExpenseResponseDto, ExpenseRepository> {
    public ExpenseService(ExpenseRepository repository, ExpenseMapper mapper) {
        super(repository, mapper);
    }
}
