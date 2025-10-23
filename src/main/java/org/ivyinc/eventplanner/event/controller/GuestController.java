package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.ApiResponse;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.Guest;
import org.ivyinc.eventplanner.event.model.Invitation;
import org.ivyinc.eventplanner.event.service.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/guests")
public class GuestController implements BaseController<Guest, GuestService> {

    private final GuestService guestService;

    @Override
    public GuestService getService() {
        return guestService;
    }

    @GetMapping("/invitation/{invitationId}")
    public ResponseEntity<ApiResponse<List<Guest>>> getGuestsByInvitation(@PathVariable Long invitationId) {
        Invitation invitation = new Invitation();
        invitation.setId(invitationId);
        List<Guest> guests = guestService.findByInvitation(invitation);
        return ResponseEntity.ok(ApiResponse.ok(guests));
    }
}