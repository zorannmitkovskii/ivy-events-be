package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.Band;
import org.ivyinc.eventplanner.event.model.FormField;
import org.ivyinc.eventplanner.event.service.BandService;
import org.ivyinc.eventplanner.event.service.FormFieldService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/form-fields")
public class FormFieldController implements BaseController<FormField, FormFieldService> {

    final FormFieldService formFieldService;

    @Override
    public FormFieldService getService() {
        return formFieldService;
    }
}
