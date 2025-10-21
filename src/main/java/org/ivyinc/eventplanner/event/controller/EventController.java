package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.event.common.BaseController;
import org.ivyinc.eventplanner.event.common.ApiResponse;
import org.ivyinc.eventplanner.event.model.Event;
import org.ivyinc.eventplanner.event.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController implements BaseController<Event, EventService> {

    private final EventService eventService;

    @Override
    public EventService getService() {
        return eventService;
    }

    // ✅ Custom endpoint example — get by public code
    @GetMapping("/public/{code}")
    public ResponseEntity<ApiResponse<Event>> getByPublicCode(@PathVariable String code) {
        return eventService.findByPublicCode(code)
                .map(event -> ResponseEntity.ok(ApiResponse.ok(event)))
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Custom endpoint example — get by ownerId
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<ApiResponse<List<Event>>> getByOwnerId(@PathVariable String ownerId) {
        var events = eventService.findByOwnerId(ownerId);
        return ResponseEntity.ok(ApiResponse.ok(events));
    }
}