package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.Dietary;
import org.ivyinc.eventplanner.event.repository.DietaryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DietaryService extends BaseService<Dietary> {

    private DietaryRepository dietaryRepository;
    @Override
    protected JpaRepository<Dietary, Long> getRepository() {
        return null;
    }
}
