package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.DietaryCreateDto;
import org.ivyinc.eventplanner.event.dto.DietaryResponseDto;
import org.ivyinc.eventplanner.event.dto.DietaryUpdateDto;
import org.ivyinc.eventplanner.event.mapper.DietaryMapper;
import org.ivyinc.eventplanner.event.model.Dietary;
import org.ivyinc.eventplanner.event.repository.DietaryRepository;
import org.springframework.stereotype.Service;

@Service
public class DietaryService extends BaseServiceImpl<Dietary, DietaryCreateDto, DietaryUpdateDto, DietaryResponseDto, DietaryRepository> {
    public DietaryService(DietaryRepository repository, DietaryMapper mapper) {
        super(repository, mapper);
    }
}
