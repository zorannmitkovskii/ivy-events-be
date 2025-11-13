package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.FeedbackCreateDto;
import org.ivyinc.eventplanner.event.dto.FeedbackResponseDto;
import org.ivyinc.eventplanner.event.dto.FeedbackUpdateDto;
import org.ivyinc.eventplanner.event.mapper.FeedbackMapper;
import org.ivyinc.eventplanner.event.model.Feedback;
import org.ivyinc.eventplanner.event.repository.FeedbackRepository;
import org.springframework.stereotype.Service;


@Service
public class FeedbackService extends BaseServiceImpl<Feedback, FeedbackCreateDto, FeedbackUpdateDto, FeedbackResponseDto, FeedbackRepository> {
    public FeedbackService(FeedbackRepository repository, FeedbackMapper mapper) {
        super(repository, mapper);
    }
}
