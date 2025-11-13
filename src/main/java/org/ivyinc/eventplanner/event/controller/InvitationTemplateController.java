package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.InvitationTemplateCreateRequestDto;
import org.ivyinc.eventplanner.event.dto.InvitationTemplateResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationTemplateUpdateRequestDto;
import org.ivyinc.eventplanner.event.model.InvitationTemplate;
import org.ivyinc.eventplanner.event.service.InvitationTemplateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/InvitationTemplates")
public class InvitationTemplateController implements BaseController<InvitationTemplate, InvitationTemplateCreateRequestDto, InvitationTemplateUpdateRequestDto, InvitationTemplateResponseDto> {

    private final InvitationTemplateService invitationTemplateService;

    @Override
    public InvitationTemplateService getService() {
        return invitationTemplateService;
    }
}
