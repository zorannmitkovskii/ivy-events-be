package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.InvitationCreateDto;
import org.ivyinc.eventplanner.event.dto.InvitationResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationUpdateDto;
import org.ivyinc.eventplanner.event.model.Invitation;
import org.ivyinc.eventplanner.event.service.InvitationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/invitations")
public class InvitationController implements BaseController<Invitation, InvitationCreateDto, InvitationUpdateDto, InvitationResponseDto> {

    private final InvitationService invitationService;

    @Override
    public InvitationService getService() {
        return invitationService;
    }
}
