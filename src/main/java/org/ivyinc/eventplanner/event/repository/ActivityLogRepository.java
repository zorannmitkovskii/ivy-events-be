package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.model.ActivityLog;

import java.util.List;

public interface ActivityLogRepository extends BaseRepository<ActivityLog> {
    List<ActivityLog> findActivityLogByOwnerId(Long ownerId);
    List<ActivityLog> findActivityLogByEventId(Long eventId);
}
