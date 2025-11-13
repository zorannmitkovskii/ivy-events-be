package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.FormCreateDto;
import org.ivyinc.eventplanner.event.dto.FormResponseDto;
import org.ivyinc.eventplanner.event.dto.FormUpdateDto;
import org.ivyinc.eventplanner.event.mapper.FormMapper;
import org.ivyinc.eventplanner.event.model.Form;
import org.ivyinc.eventplanner.event.repository.FormRepository;
import org.springframework.stereotype.Service;


@Service
public class FormService extends BaseServiceImpl<Form, FormCreateDto, FormUpdateDto, FormResponseDto, FormRepository> {
    public FormService(FormRepository repository, FormMapper mapper) {
        super(repository, mapper);
    }
}
