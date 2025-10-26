package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.ApiResponse;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.InvitationSection;
import org.ivyinc.eventplanner.event.service.InvitationSectionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/invitation-sections")
public class InvitationSectionController implements BaseController<InvitationSection, InvitationSectionService> {

    private final InvitationSectionService service;

    @Override
    public InvitationSectionService getService() {
        return service;
    }

    @GetMapping("/template/{templateId}")
    public ResponseEntity<ApiResponse<Page<InvitationSection>>> findByTemplateId(@PathVariable Long templateId, Pageable pageable) {
        Page<InvitationSection> page = service.findByTemplateId(templateId, pageable);
        return ResponseEntity.ok(ApiResponse.ok(page));
    }
}
