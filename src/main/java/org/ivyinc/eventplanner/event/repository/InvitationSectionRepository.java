package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.model.InvitationSection;

import java.util.List;

public interface InvitationSectionRepository extends BaseRepository<InvitationSection> {
    List<InvitationSection> findByTemplateIdOrderByOrderIndexAsc(Long templateId);
}
