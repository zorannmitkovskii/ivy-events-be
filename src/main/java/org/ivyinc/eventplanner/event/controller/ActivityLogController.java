package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.ApiResponse;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.ActivityLog;
import org.ivyinc.eventplanner.event.service.ActivityLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/designs")
public class ActivityLogController implements BaseController<ActivityLog, ActivityLogService> {

    final ActivityLogService activityLogService;

    @Override
    public ActivityLogService getService() {
        return activityLogService;
    }

    @GetMapping("/user/{ownerId}")
    public ResponseEntity<ApiResponse<List<ActivityLog>>> getByUser(@PathVariable Long ownerId) {
        List<ActivityLog> logs = activityLogService.findByUser(ownerId);
        return ResponseEntity.ok(ApiResponse.ok(logs));
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<ApiResponse<List<ActivityLog>>> getByEvent(@PathVariable Long eventId) {
        List<ActivityLog> logs = activityLogService.findByEvent(eventId);
        return ResponseEntity.ok(ApiResponse.ok(logs));
    }
}
