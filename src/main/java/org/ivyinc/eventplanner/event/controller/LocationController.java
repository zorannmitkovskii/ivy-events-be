package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.LocationCreateDto;
import org.ivyinc.eventplanner.event.dto.LocationResponseDto;
import org.ivyinc.eventplanner.event.dto.LocationUpdateDto;
import org.ivyinc.eventplanner.event.model.Location;
import org.ivyinc.eventplanner.event.service.LocationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/locations")
public class LocationController implements BaseController<Location, LocationCreateDto, LocationUpdateDto, LocationResponseDto> {

    private final LocationService locationService;

    @Override
    public LocationService getService() {
        return locationService;
    }
}