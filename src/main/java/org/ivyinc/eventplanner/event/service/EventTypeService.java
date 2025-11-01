package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.EventTypeCreateDto;
import org.ivyinc.eventplanner.event.dto.EventTypeResponseDto;
import org.ivyinc.eventplanner.event.dto.EventTypeUpdateDto;
import org.ivyinc.eventplanner.event.mapper.EventTypeMapper;
import org.ivyinc.eventplanner.event.model.EventType;
import org.ivyinc.eventplanner.event.repository.EventTypeRepository;
import org.springframework.stereotype.Service;


@Service
public class EventTypeService extends BaseServiceImpl<EventType, EventTypeCreateDto, EventTypeUpdateDto, EventTypeResponseDto, EventTypeRepository> {
    public EventTypeService(EventTypeRepository repository, EventTypeMapper mapper) {
        super(repository, mapper);
    }
}
