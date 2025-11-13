package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.InvitationSectionCreateDto;
import org.ivyinc.eventplanner.event.dto.InvitationSectionResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationSectionUpdateDto;
import org.ivyinc.eventplanner.event.model.InvitationSection;
import org.ivyinc.eventplanner.event.service.InvitationSectionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/invitation-sections")
public class InvitationSectionController implements BaseController<InvitationSection, InvitationSectionCreateDto, InvitationSectionUpdateDto, InvitationSectionResponseDto> {

    private final InvitationSectionService invitationSectionService;

    @Override
    public InvitationSectionService getService() {
        return invitationSectionService;
    }
}
