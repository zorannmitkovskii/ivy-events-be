package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.Form;
import org.ivyinc.eventplanner.event.service.FormService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/form")

public class FormController implements BaseController<Form, FormService> {

    private final FormService formService;

    @Override
    public FormService getService() {
        return formService;
    }

}