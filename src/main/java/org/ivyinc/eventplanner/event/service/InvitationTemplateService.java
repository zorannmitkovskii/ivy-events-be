package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.InvitationTemplate;
import org.ivyinc.eventplanner.event.repository.InvitationTemplateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvitationTemplateService extends BaseService<InvitationTemplate> {

    private final InvitationTemplateRepository repository;

    @Override
    protected JpaRepository<InvitationTemplate, Long> getRepository() {
        return repository;
    }
}
