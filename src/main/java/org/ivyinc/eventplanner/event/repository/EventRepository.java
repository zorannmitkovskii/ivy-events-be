package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends BaseRepository<Event> {

    List<Event> findByOwnerId(String ownerId);

    Optional<Event> findByPublicCode(String publicCode);
}
