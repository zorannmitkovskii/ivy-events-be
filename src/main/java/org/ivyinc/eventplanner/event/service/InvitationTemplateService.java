package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.InvitationTemplateCreateDto;
import org.ivyinc.eventplanner.event.dto.InvitationTemplateResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationTemplateUpdateDto;
import org.ivyinc.eventplanner.event.mapper.InvitationTemplateMapper;
import org.ivyinc.eventplanner.event.model.InvitationTemplate;
import org.ivyinc.eventplanner.event.repository.InvitationTemplateRepository;
import org.springframework.stereotype.Service;

@Service
public class InvitationTemplateService extends BaseServiceImpl<InvitationTemplate, InvitationTemplateCreateDto, InvitationTemplateUpdateDto, InvitationTemplateResponseDto, InvitationTemplateRepository> {
    public InvitationTemplateService(InvitationTemplateRepository repository, InvitationTemplateMapper mapper) {
        super(repository, mapper);
    }
}
