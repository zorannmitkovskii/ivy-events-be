package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.EventCreateDto;
import org.ivyinc.eventplanner.event.dto.EventResponseDto;
import org.ivyinc.eventplanner.event.dto.EventUpdateDto;
import org.ivyinc.eventplanner.event.mapper.EventMapper;
import org.ivyinc.eventplanner.event.model.Event;
import org.ivyinc.eventplanner.event.repository.EventRepository;
import org.springframework.stereotype.Service;


@Service
public class EventService extends BaseServiceImpl<Event, EventCreateDto, EventUpdateDto, EventResponseDto, EventRepository> {
    public EventService(EventRepository repository, EventMapper mapper) {
        super(repository, mapper);
    }
}
