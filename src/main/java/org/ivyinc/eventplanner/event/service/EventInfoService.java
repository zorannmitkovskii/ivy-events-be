package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.EventInfoCreateDto;
import org.ivyinc.eventplanner.event.dto.EventInfoResponseDto;
import org.ivyinc.eventplanner.event.dto.EventInfoUpdateDto;
import org.ivyinc.eventplanner.event.mapper.EventInfoMapper;
import org.ivyinc.eventplanner.event.model.EventInfo;
import org.ivyinc.eventplanner.event.repository.EventInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class EventInfoService extends BaseServiceImpl<EventInfo, EventInfoCreateDto, EventInfoUpdateDto, EventInfoResponseDto, EventInfoRepository> {
    public EventInfoService(EventInfoRepository repository, EventInfoMapper mapper) {
        super(repository, mapper);
    }
}
