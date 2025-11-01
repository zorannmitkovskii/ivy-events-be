package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.EventCategoryCreateDto;
import org.ivyinc.eventplanner.event.dto.EventCategoryResponseDto;
import org.ivyinc.eventplanner.event.dto.EventCategoryUpdateDto;
import org.ivyinc.eventplanner.event.mapper.EventCategoryMapper;
import org.ivyinc.eventplanner.event.model.EventCategory;
import org.ivyinc.eventplanner.event.repository.EventCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class EventCategoryService extends BaseServiceImpl<EventCategory, EventCategoryCreateDto, EventCategoryUpdateDto, EventCategoryResponseDto, EventCategoryRepository> {
    public EventCategoryService(EventCategoryRepository repository, EventCategoryMapper mapper) {
        super(repository, mapper);
    }
}
