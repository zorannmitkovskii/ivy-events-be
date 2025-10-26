package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.model.Guest;
import org.ivyinc.eventplanner.event.model.Invitation;

import java.util.List;

public interface GuestRepository extends BaseRepository<Guest> {
    List<Guest> findByInvitation(Invitation invitation);
}
