package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.GuestCreateDto;
import org.ivyinc.eventplanner.event.dto.GuestResponseDto;
import org.ivyinc.eventplanner.event.dto.GuestUpdateDto;
import org.ivyinc.eventplanner.event.mapper.GuestMapper;
import org.ivyinc.eventplanner.event.model.Guest;
import org.ivyinc.eventplanner.event.repository.GuestRepository;
import org.springframework.stereotype.Service;


@Service
public class GuestService extends BaseServiceImpl<Guest, GuestCreateDto, GuestUpdateDto, GuestResponseDto, GuestRepository> {
    public GuestService(GuestRepository repository, GuestMapper mapper) {
        super(repository, mapper);
    }
}
