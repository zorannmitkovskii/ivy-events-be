package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.FeedbackCreateDto;
import org.ivyinc.eventplanner.event.dto.FeedbackResponseDto;
import org.ivyinc.eventplanner.event.dto.FeedbackUpdateDto;
import org.ivyinc.eventplanner.event.model.Feedback;
import org.ivyinc.eventplanner.event.service.FeedbackService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/feedbacks")
public class FeedbackController implements BaseController<Feedback, FeedbackCreateDto, FeedbackUpdateDto, FeedbackResponseDto> {

    private final FeedbackService feedbackService;

    @Override
    public FeedbackService getService() {
        return feedbackService;
    }
}