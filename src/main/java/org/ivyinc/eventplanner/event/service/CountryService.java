package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.CountryCreateDto;
import org.ivyinc.eventplanner.event.dto.CountryResponseDto;
import org.ivyinc.eventplanner.event.dto.CountryUpdateDto;
import org.ivyinc.eventplanner.event.mapper.CountryMapper;
import org.ivyinc.eventplanner.event.model.Country;
import org.ivyinc.eventplanner.event.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends BaseServiceImpl<Country, CountryCreateDto, CountryUpdateDto, CountryResponseDto, CountryRepository> {
    public CountryService(CountryRepository repository, CountryMapper mapper) {
        super(repository, mapper);
    }
}
