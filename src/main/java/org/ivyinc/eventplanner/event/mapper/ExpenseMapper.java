package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.ExpenseCreateDto;
import org.ivyinc.eventplanner.event.dto.ExpenseResponseDto;
import org.ivyinc.eventplanner.event.dto.ExpenseUpdateDto;
import org.ivyinc.eventplanner.event.model.Expense;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {BudgetMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ExpenseMapper extends BaseMapper<Expense, ExpenseCreateDto, ExpenseUpdateDto, ExpenseResponseDto>{

    @Override
    @Mappings({
            @Mapping(target = "budget", ignore = true)
    })
    Expense toEntity(ExpenseCreateDto dto);

    @Override
    @Mappings({
            @Mapping(target = "budget", ignore = true)
    })
    void updateEntity(@MappingTarget Expense entity, ExpenseUpdateDto dto);
}