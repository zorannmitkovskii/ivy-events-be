package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.Invitation;
import org.ivyinc.eventplanner.event.repository.InvitationRepository;
import org.ivyinc.eventplanner.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvitationService extends BaseService<Invitation> {

    private final InvitationRepository invitationRepository;

    @Override
    protected JpaRepository<Invitation, Long> getRepository() {
        return invitationRepository;
    }

    public List<Invitation> findByEvent(Event event) {
        return invitationRepository.findByEvent(event);
    }

    public Optional<Invitation> findByPublicCode(String publicCode) {
        return invitationRepository.findByPublicCode(publicCode);
    }
}