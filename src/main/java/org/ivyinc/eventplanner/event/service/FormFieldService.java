package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.Band;
import org.ivyinc.eventplanner.event.model.FormField;
import org.ivyinc.eventplanner.event.repository.BandRepository;
import org.ivyinc.eventplanner.event.repository.FormFieldRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormFieldService extends BaseService<FormField> {

    private final FormFieldRepository formFieldRepository;

    @Override
    protected BaseRepository<FormField> getRepository() {
        return formFieldRepository;
    }
}
