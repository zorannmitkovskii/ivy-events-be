package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.Guest;
import org.ivyinc.eventplanner.event.model.Invitation;
import org.ivyinc.eventplanner.event.repository.GuestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService extends BaseService<Guest> {

    private final GuestRepository guestRepository;

    @Override
    protected JpaRepository<Guest, Long> getRepository() {
        return guestRepository;
    }

    public List<Guest> findByInvitation(Invitation invitation) {
        return guestRepository.findByInvitation(invitation);
    }
}
