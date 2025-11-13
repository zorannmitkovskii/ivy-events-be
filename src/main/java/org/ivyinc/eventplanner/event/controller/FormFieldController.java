package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.FormFieldCreateDto;
import org.ivyinc.eventplanner.event.dto.FormFieldResponseDto;
import org.ivyinc.eventplanner.event.dto.FormFieldUpdateDto;
import org.ivyinc.eventplanner.event.model.FormField;
import org.ivyinc.eventplanner.event.service.FormFieldService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/form-fields")
public class FormFieldController implements BaseController<FormField, FormFieldCreateDto, FormFieldUpdateDto, FormFieldResponseDto> {

    private final FormFieldService formFieldService;

    @Override
    public FormFieldService getService() {
        return formFieldService;
    }
}