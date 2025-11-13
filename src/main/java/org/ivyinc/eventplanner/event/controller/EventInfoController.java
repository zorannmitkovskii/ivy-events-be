package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.EventInfoCreateDto;
import org.ivyinc.eventplanner.event.dto.EventInfoResponseDto;
import org.ivyinc.eventplanner.event.dto.EventInfoUpdateDto;
import org.ivyinc.eventplanner.event.model.EventInfo;
import org.ivyinc.eventplanner.event.service.EventInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/event-infos")
public class EventInfoController implements BaseController<EventInfo, EventInfoCreateDto, EventInfoUpdateDto, EventInfoResponseDto> {

    private final EventInfoService eventInfoService;

    @Override
    public EventInfoService getService() {
        return eventInfoService;
    }
}
