package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.ActivityLogCreateDto;
import org.ivyinc.eventplanner.event.dto.ActivityLogResponseDto;
import org.ivyinc.eventplanner.event.dto.ActivityLogUpdateDto;
import org.ivyinc.eventplanner.event.model.ActivityLog;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ActivityLogMapper extends BaseMapper<ActivityLog, ActivityLogCreateDto, ActivityLogUpdateDto, ActivityLogResponseDto>{
}