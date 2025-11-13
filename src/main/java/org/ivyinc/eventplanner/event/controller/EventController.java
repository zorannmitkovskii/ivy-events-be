package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.EventCreateDto;
import org.ivyinc.eventplanner.event.dto.EventResponseDto;
import org.ivyinc.eventplanner.event.dto.EventUpdateDto;
import org.ivyinc.eventplanner.event.model.Event;
import org.ivyinc.eventplanner.event.service.EventService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/events")
public class EventController implements BaseController<Event, EventCreateDto, EventUpdateDto, EventResponseDto> {

    private final EventService eventService;

    @Override
    public EventService getService() {
        return eventService;
    }
}