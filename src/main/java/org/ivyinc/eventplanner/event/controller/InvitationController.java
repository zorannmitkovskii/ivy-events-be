package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.ApiResponse;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.Invitation;
import org.ivyinc.eventplanner.event.service.InvitationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/invitations")
public class InvitationController implements BaseController<Invitation, InvitationService> {

    private final InvitationService invitationService;

    @Override
    public InvitationService getService() {
        return invitationService;
    }

    // ✅ Custom endpoint — find by public code
    @GetMapping("/public/{code}")
    public ResponseEntity<ApiResponse<Invitation>> getByPublicCode(@PathVariable String code) {
        return invitationService.findByPublicCode(code)
                .map(invite -> ResponseEntity.ok(ApiResponse.ok(invite)))
                .orElse(ResponseEntity.notFound().build());
    }
}
