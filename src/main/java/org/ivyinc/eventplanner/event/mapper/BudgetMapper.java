package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.BudgetCreateDto;
import org.ivyinc.eventplanner.event.dto.BudgetResponseDto;
import org.ivyinc.eventplanner.event.dto.BudgetUpdateDto;
import org.ivyinc.eventplanner.event.model.Budget;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BudgetMapper extends BaseMapper<Budget, BudgetCreateDto, BudgetUpdateDto, BudgetResponseDto>{
}