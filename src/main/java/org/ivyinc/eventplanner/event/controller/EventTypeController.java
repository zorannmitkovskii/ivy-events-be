package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.EventTypeCreateDto;
import org.ivyinc.eventplanner.event.dto.EventTypeResponseDto;
import org.ivyinc.eventplanner.event.dto.EventTypeUpdateDto;
import org.ivyinc.eventplanner.event.model.EventType;
import org.ivyinc.eventplanner.event.service.EventTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/event-types")
public class EventTypeController implements BaseController<EventType, EventTypeCreateDto, EventTypeUpdateDto, EventTypeResponseDto> {

    private final EventTypeService eventTypeService;

    @Override
    public EventTypeService getService() {
        return eventTypeService;
    }
}