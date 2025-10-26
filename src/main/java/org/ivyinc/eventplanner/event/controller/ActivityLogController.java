package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.ActivityLog;
import org.ivyinc.eventplanner.event.service.ActivityLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/activity-logs")
public class ActivityLogController implements BaseController<ActivityLog, ActivityLogService> {

    final ActivityLogService activityLogService;

    @Override
    public ActivityLogService getService() {
        return activityLogService;
    }
}
