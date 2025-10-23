package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.model.Event;
import org.ivyinc.eventplanner.event.model.Invitation;

import java.util.List;
import java.util.Optional;

public interface InvitationRepository extends BaseRepository<Invitation> {

    List<Invitation> findByEvent(Event event);

    Optional<Invitation> findByPublicCode(String publicCode);
}