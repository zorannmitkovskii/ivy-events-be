package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.InvitationSection;
import org.ivyinc.eventplanner.event.repository.InvitationSectionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvitationSectionService extends BaseService<InvitationSection> {

    private final InvitationSectionRepository repository;

    @Override
    protected JpaRepository<InvitationSection, Long> getRepository() {
        return repository;
    }

    public Page<InvitationSection> findByTemplateId(Long templateId, Pageable pageable) {
        // Simple in-memory pagination leveraging repository method
        List<InvitationSection> all = repository.findByTemplateIdOrderByOrderIndexAsc(templateId);
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), all.size());
        List<InvitationSection> content = start > end ? List.of() : all.subList(start, end);
        return new PageImpl<>(content, pageable, all.size());
    }
}
