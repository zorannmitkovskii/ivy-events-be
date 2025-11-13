package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.InvitationSectionCreateDto;
import org.ivyinc.eventplanner.event.dto.InvitationSectionResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationSectionUpdateDto;
import org.ivyinc.eventplanner.event.mapper.InvitationSectionMapper;
import org.ivyinc.eventplanner.event.model.InvitationSection;
import org.ivyinc.eventplanner.event.repository.InvitationSectionRepository;
import org.springframework.stereotype.Service;


@Service
public class InvitationSectionService extends BaseServiceImpl<InvitationSection, InvitationSectionCreateDto, InvitationSectionUpdateDto, InvitationSectionResponseDto, InvitationSectionRepository> {
    public InvitationSectionService(InvitationSectionRepository repository, InvitationSectionMapper mapper) {
        super(repository, mapper);
    }
}