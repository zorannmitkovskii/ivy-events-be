package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.ScheduleCreateDto;
import org.ivyinc.eventplanner.event.dto.ScheduleResponseDto;
import org.ivyinc.eventplanner.event.dto.ScheduleUpdateDto;
import org.ivyinc.eventplanner.event.model.Schedule;
import org.ivyinc.eventplanner.event.service.ScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/schedules")
public class ScheduleController implements BaseController<Schedule, ScheduleCreateDto, ScheduleUpdateDto, ScheduleResponseDto> {

    private final ScheduleService scheduleService;

    @Override
    public ScheduleService getService() {
        return scheduleService;
    }
}
