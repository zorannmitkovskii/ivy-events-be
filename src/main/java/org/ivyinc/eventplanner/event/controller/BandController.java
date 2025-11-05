package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.BandCreateDto;
import org.ivyinc.eventplanner.event.dto.BandResponseDto;
import org.ivyinc.eventplanner.event.dto.BandUpdateDto;
import org.ivyinc.eventplanner.event.model.Band;
import org.ivyinc.eventplanner.event.service.BandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/v1/api/bands"})
public class BandController implements BaseController<Band, BandCreateDto, BandUpdateDto, BandResponseDto> {

    private final BandService bandService;

    @Override
    public BandService getService() {
        return bandService;
    }
}
