package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.EventCreateDto;
import org.ivyinc.eventplanner.event.dto.EventResponseDto;
import org.ivyinc.eventplanner.event.dto.EventUpdateDto;
import org.ivyinc.eventplanner.event.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {EventTypeMapper.class})
public interface EventMapper extends BaseMapper<Event, EventCreateDto, EventUpdateDto, EventResponseDto>{
    @Override
    @Mappings({
            @Mapping(target = "eventTypeResponseDto", source = "eventType"),
            @Mapping(target = "eventInfoResponseDto", source = "eventInfo"),
            @Mapping(target = "locationResponseDto", source = "location")
    })
    EventResponseDto toResponse(Event entity);
}