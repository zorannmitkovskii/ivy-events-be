package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.ActivityLogCreateDto;
import org.ivyinc.eventplanner.event.dto.ActivityLogResponseDto;
import org.ivyinc.eventplanner.event.dto.ActivityLogUpdateDto;
import org.ivyinc.eventplanner.event.model.ActivityLog;
import org.ivyinc.eventplanner.event.service.ActivityLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/activity-logs")
public class ActivityLogController implements BaseController<ActivityLog, ActivityLogCreateDto, ActivityLogUpdateDto, ActivityLogResponseDto> {

    private final ActivityLogService activityLogService;

    @Override
    public ActivityLogService getService() {
        return activityLogService;
    }
}
