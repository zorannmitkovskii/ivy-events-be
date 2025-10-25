package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.Feedback;
import org.ivyinc.eventplanner.event.service.FeedbackService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/feedback")
public class FeedbackController implements BaseController<Feedback, FeedbackService> {

    private final FeedbackService feedbackService;

    @Override
    public FeedbackService getService() {
        return feedbackService;
    }

}