package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.EventCategory;
import org.ivyinc.eventplanner.event.service.EventCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/event-categories")
public class EventCategoryController implements BaseController<EventCategory, EventCategoryService> {
    private final EventCategoryService eventCategoryService;

    @Override
    public EventCategoryService getService() {
        return eventCategoryService;
    }
}