package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.BandCreateDto;
import org.ivyinc.eventplanner.event.dto.BandResponseDto;
import org.ivyinc.eventplanner.event.dto.BandUpdateDto;
import org.ivyinc.eventplanner.event.mapper.BandMapper;
import org.ivyinc.eventplanner.event.model.Band;
import org.ivyinc.eventplanner.event.repository.BandRepository;
import org.springframework.stereotype.Service;

@Service
public class BandService extends BaseServiceImpl<Band, BandCreateDto, BandUpdateDto, BandResponseDto, BandRepository> {
    public BandService(BandRepository repository, BandMapper mapper) {
        super(repository, mapper);
    }
}
