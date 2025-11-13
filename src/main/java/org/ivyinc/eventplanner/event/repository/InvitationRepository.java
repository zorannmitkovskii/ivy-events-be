package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.model.Invitation;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationRepository extends BaseRepository<Invitation> {
}