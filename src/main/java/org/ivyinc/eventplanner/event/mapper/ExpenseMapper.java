package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.ExpenseCreateDto;
import org.ivyinc.eventplanner.event.dto.ExpenseResponseDto;
import org.ivyinc.eventplanner.event.dto.ExpenseUpdateDto;
import org.ivyinc.eventplanner.event.model.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ExpenseMapper extends BaseMapper<Expense, ExpenseCreateDto, ExpenseUpdateDto, ExpenseResponseDto>{
}