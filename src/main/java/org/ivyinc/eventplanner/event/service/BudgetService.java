package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.BudgetCreateDto;
import org.ivyinc.eventplanner.event.dto.BudgetResponseDto;
import org.ivyinc.eventplanner.event.dto.BudgetUpdateDto;
import org.ivyinc.eventplanner.event.mapper.BudgetMapper;
import org.ivyinc.eventplanner.event.model.Budget;
import org.ivyinc.eventplanner.event.repository.BudgetRepository;
import org.springframework.stereotype.Service;

@Service
public class BudgetService extends BaseServiceImpl<Budget, BudgetCreateDto, BudgetUpdateDto, BudgetResponseDto, BudgetRepository> {
    public BudgetService(BudgetRepository repository, BudgetMapper mapper) {
        super(repository, mapper);
    }
}
