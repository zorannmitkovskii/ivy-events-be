package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.event.common.BaseService;
import org.ivyinc.eventplanner.event.model.Event;
import org.ivyinc.eventplanner.event.repository.EventRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService extends BaseService<Event> {

    private final EventRepository eventRepository;

    @Override
    protected JpaRepository<Event, Long> getRepository() {
        return eventRepository;
    }

    public List<Event> findByOwnerId(String ownerId) {
        return eventRepository.findByOwnerId(ownerId);
    }

    public Optional<Event> findByPublicCode(String publicCode) {
        return eventRepository.findByPublicCode(publicCode);
    }
}
