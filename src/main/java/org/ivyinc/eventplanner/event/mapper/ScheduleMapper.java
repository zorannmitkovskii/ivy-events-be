package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.ScheduleCreateDto;
import org.ivyinc.eventplanner.event.dto.ScheduleResponseDto;
import org.ivyinc.eventplanner.event.dto.ScheduleUpdateDto;
import org.ivyinc.eventplanner.event.model.Event;
import org.ivyinc.eventplanner.event.model.Location;
import org.ivyinc.eventplanner.event.model.Schedule;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ScheduleMapper extends BaseMapper<Schedule, ScheduleCreateDto, ScheduleUpdateDto, ScheduleResponseDto> {
}
