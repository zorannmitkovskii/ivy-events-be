package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.model.EventType;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends BaseRepository<EventType> {
}
