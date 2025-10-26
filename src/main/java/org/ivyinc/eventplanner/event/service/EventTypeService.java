package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.EventType;
import org.ivyinc.eventplanner.event.repository.EventTypeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventTypeService extends BaseService<EventType> {

    private final EventTypeRepository eventTypeRepository;

    @Override
    protected JpaRepository<EventType, Long> getRepository() {
        return eventTypeRepository;
    }
}
