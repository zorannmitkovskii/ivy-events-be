package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.model.Guest;
import org.ivyinc.eventplanner.event.model.Invitation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends BaseRepository<Guest> {
}
