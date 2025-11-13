package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.FormFieldCreateDto;
import org.ivyinc.eventplanner.event.dto.FormFieldResponseDto;
import org.ivyinc.eventplanner.event.dto.FormFieldUpdateDto;
import org.ivyinc.eventplanner.event.mapper.FormFieldMapper;
import org.ivyinc.eventplanner.event.model.FormField;
import org.ivyinc.eventplanner.event.repository.FormFieldRepository;
import org.springframework.stereotype.Service;


@Service
public class FormFieldService extends BaseServiceImpl<FormField, FormFieldCreateDto, FormFieldUpdateDto, FormFieldResponseDto, FormFieldRepository> {
    public FormFieldService(FormFieldRepository repository, FormFieldMapper mapper) {
        super(repository, mapper);
    }
}