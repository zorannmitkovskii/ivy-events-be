package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.EventCategory;
import org.ivyinc.eventplanner.event.repository.EventCategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventCategoryService extends BaseService<EventCategory> {

    private EventCategoryRepository eventCategoryRepository;

    @Override
    protected BaseRepository<EventCategory> getRepository() {
        return eventCategoryRepository;
    }
}
