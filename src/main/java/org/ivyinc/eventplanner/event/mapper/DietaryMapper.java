package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.DietaryCreateDto;
import org.ivyinc.eventplanner.event.dto.DietaryResponseDto;
import org.ivyinc.eventplanner.event.dto.DietaryUpdateDto;
import org.ivyinc.eventplanner.event.model.Dietary;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DietaryMapper extends BaseMapper<Dietary, DietaryCreateDto, DietaryUpdateDto, DietaryResponseDto>{
}