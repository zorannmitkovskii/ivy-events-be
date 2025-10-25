package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.Feedback;
import org.ivyinc.eventplanner.event.repository.FeedbackRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedbackService extends BaseService<Feedback> {

    private FeedbackRepository feedbackRepository;

    @Override
    protected JpaRepository<Feedback, Long> getRepository() {
        return feedbackRepository;
    }
}
