package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.EventTypeCreateDto;
import org.ivyinc.eventplanner.event.dto.EventTypeResponseDto;
import org.ivyinc.eventplanner.event.dto.EventTypeUpdateDto;
import org.ivyinc.eventplanner.event.model.EventType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EventCategoryMapper.class})
public interface EventTypeMapper extends BaseMapper<EventType, EventTypeCreateDto, EventTypeUpdateDto, EventTypeResponseDto>{
    @Override
    @Mapping(target = "eventCategoryResponseDto", source = "eventCategory")
    EventTypeResponseDto toResponse(EventType entity);
}