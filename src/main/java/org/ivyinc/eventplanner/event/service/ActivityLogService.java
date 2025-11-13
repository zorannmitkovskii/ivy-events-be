package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.ActivityLogCreateDto;
import org.ivyinc.eventplanner.event.dto.ActivityLogResponseDto;
import org.ivyinc.eventplanner.event.dto.ActivityLogUpdateDto;
import org.ivyinc.eventplanner.event.mapper.ActivityLogMapper;
import org.ivyinc.eventplanner.event.model.ActivityLog;
import org.ivyinc.eventplanner.event.repository.ActivityLogRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogService extends BaseServiceImpl<ActivityLog, ActivityLogCreateDto, ActivityLogUpdateDto, ActivityLogResponseDto, ActivityLogRepository> {

    public ActivityLogService(ActivityLogRepository repository, BaseMapper<ActivityLog, ActivityLogCreateDto, ActivityLogUpdateDto, ActivityLogResponseDto> mapper) {
        super(repository, mapper);
    }
}

