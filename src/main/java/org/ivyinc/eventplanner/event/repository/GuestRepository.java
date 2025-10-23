package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.model.Guest;
import org.ivyinc.eventplanner.event.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends BaseRepository<Guest> {
    List<Guest> findByInvitation(Invitation invitation);
}
