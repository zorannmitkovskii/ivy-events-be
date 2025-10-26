package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.ApiResponse;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.ActivityLog;
import org.ivyinc.eventplanner.event.model.Band;
import org.ivyinc.eventplanner.event.service.ActivityLogService;
import org.ivyinc.eventplanner.event.service.BandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/bands")
public class BandController implements BaseController<Band, BandService> {

    final BandService bandService;

    @Override
    public BandService getService() {
        return bandService;
    }
}
