package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.EventTypeCreateDto;
import org.ivyinc.eventplanner.event.dto.EventTypeResponseDto;
import org.ivyinc.eventplanner.event.dto.EventTypeUpdateDto;
import org.ivyinc.eventplanner.event.model.EventCategory;
import org.ivyinc.eventplanner.event.model.EventType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.UUID;

@Mapper(
        componentModel = "spring",
        uses = {EventCategoryMapper.class}
)
public interface EventTypeMapper extends BaseMapper<EventType, EventTypeCreateDto, EventTypeUpdateDto, EventTypeResponseDto> {

    @Override
    @Mapping(target = "eventCategory", source = "eventCategoryId")
    EventType toEntity(EventTypeCreateDto dto);


    @Override
    @Mapping(target = "eventCategory", source = "eventCategoryId")
    void updateEntity(@MappingTarget EventType entity, EventTypeUpdateDto dto);

    // Helper for mapping UUID -> EventCategory reference
    default EventCategory map(UUID id) {
        if (id == null) return null;
        EventCategory ec = new EventCategory();
        ec.setId(id);
        return ec;
    }
}