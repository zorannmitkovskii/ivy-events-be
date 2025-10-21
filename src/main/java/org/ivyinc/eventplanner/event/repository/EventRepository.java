package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByOwnerId(String ownerId);

    Optional<Event> findByPublicCode(String publicCode);
}
