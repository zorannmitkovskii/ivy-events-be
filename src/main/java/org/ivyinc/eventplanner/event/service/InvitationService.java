package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.InvitationCreateDto;
import org.ivyinc.eventplanner.event.dto.InvitationResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationUpdateDto;
import org.ivyinc.eventplanner.event.mapper.InvitationMapper;
import org.ivyinc.eventplanner.event.model.Invitation;
import org.ivyinc.eventplanner.event.repository.InvitationRepository;
import org.springframework.stereotype.Service;


@Service
public class InvitationService extends BaseServiceImpl<Invitation, InvitationCreateDto, InvitationUpdateDto, InvitationResponseDto, InvitationRepository> {
    public InvitationService(InvitationRepository repository, InvitationMapper mapper) {
        super(repository, mapper);
    }
}