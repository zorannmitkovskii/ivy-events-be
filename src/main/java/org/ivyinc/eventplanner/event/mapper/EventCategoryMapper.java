package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.EventCategoryCreateDto;
import org.ivyinc.eventplanner.event.dto.EventCategoryResponseDto;
import org.ivyinc.eventplanner.event.dto.EventCategoryUpdateDto;
import org.ivyinc.eventplanner.event.model.EventCategory;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EventCategoryMapper extends BaseMapper<EventCategory, EventCategoryCreateDto, EventCategoryUpdateDto, EventCategoryResponseDto>{
}