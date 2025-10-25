package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.Dietary;
import org.ivyinc.eventplanner.event.service.DietaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/dietaries")
public class DietaryController implements BaseController<Dietary, DietaryService> {

    private DietaryService dietaryService;

    @Override
    public DietaryService getService() {
        return dietaryService;
    }
}
