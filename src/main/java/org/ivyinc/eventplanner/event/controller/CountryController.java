package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.CountryCreateDto;
import org.ivyinc.eventplanner.event.dto.CountryResponseDto;
import org.ivyinc.eventplanner.event.dto.CountryUpdateDto;
import org.ivyinc.eventplanner.event.model.Country;
import org.ivyinc.eventplanner.event.service.CountryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/countries")
public class CountryController implements BaseController<Country, CountryCreateDto, CountryUpdateDto, CountryResponseDto> {

    private final CountryService service;

    @Override
    public CountryService getService() {
        return service;
    }
}
