package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.ActivityLog;
import org.ivyinc.eventplanner.event.repository.ActivityLogRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogService extends BaseService<ActivityLog> {

    private final ActivityLogRepository activityLogRepository;

    @Override
    protected JpaRepository<ActivityLog, Long> getRepository() {
        return activityLogRepository;
    }

    public List<ActivityLog> findByUser(Long ownerId) {
        return activityLogRepository.findActivityLogByOwnerId(ownerId);
    }

    public List<ActivityLog> findByEvent(Long eventId) {
        return activityLogRepository.findActivityLogByEventId(eventId);
    }

}
