package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.InvitationTemplate;
import org.ivyinc.eventplanner.event.service.InvitationTemplateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/invitation-templates")
public class InvitationTemplateController implements BaseController<InvitationTemplate, InvitationTemplateService> {

    private final InvitationTemplateService service;

    @Override
    public InvitationTemplateService getService() {
        return service;
    }
}
