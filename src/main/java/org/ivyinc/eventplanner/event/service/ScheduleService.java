package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.ScheduleCreateDto;
import org.ivyinc.eventplanner.event.dto.ScheduleResponseDto;
import org.ivyinc.eventplanner.event.dto.ScheduleUpdateDto;
import org.ivyinc.eventplanner.event.mapper.ScheduleMapper;
import org.ivyinc.eventplanner.event.model.Schedule;
import org.ivyinc.eventplanner.event.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService extends BaseServiceImpl<Schedule, ScheduleCreateDto, ScheduleUpdateDto, ScheduleResponseDto, ScheduleRepository> {

    public ScheduleService(ScheduleRepository repository, ScheduleMapper mapper) {
        super(repository, mapper);
    }
}
