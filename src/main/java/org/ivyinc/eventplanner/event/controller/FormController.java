package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.FormCreateDto;
import org.ivyinc.eventplanner.event.dto.FormResponseDto;
import org.ivyinc.eventplanner.event.dto.FormUpdateDto;
import org.ivyinc.eventplanner.event.model.Form;
import org.ivyinc.eventplanner.event.service.FormService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/forms")
public class FormController implements BaseController<Form, FormCreateDto, FormUpdateDto, FormResponseDto> {

    private final FormService formService;

    @Override
    public FormService getService() {
        return formService;
    }
}