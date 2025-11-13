package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.GuestCreateDto;
import org.ivyinc.eventplanner.event.dto.GuestResponseDto;
import org.ivyinc.eventplanner.event.dto.GuestUpdateDto;
import org.ivyinc.eventplanner.event.model.Guest;
import org.ivyinc.eventplanner.event.service.GuestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/guests")
public class GuestController implements BaseController<Guest, GuestCreateDto, GuestUpdateDto, GuestResponseDto> {

    private final GuestService guestService;

    @Override
    public GuestService getService() {
        return guestService;
    }
}