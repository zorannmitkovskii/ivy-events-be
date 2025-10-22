package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.event.model.Invitation;
import org.ivyinc.eventplanner.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {

    List<Invitation> findByEvent(Event event);

    Optional<Invitation> findByPublicCode(String publicCode);
}