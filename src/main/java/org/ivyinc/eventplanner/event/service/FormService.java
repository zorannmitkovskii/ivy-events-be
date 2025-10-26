package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.Form;
import org.ivyinc.eventplanner.event.repository.FormRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormService extends BaseService<Form> {

    private FormRepository formRepository;

    @Override
    protected JpaRepository<Form, Long> getRepository() {
        return null;
    }
}
