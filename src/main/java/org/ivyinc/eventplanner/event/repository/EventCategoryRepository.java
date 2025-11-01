package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.model.EventCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCategoryRepository extends BaseRepository<EventCategory> {
}
