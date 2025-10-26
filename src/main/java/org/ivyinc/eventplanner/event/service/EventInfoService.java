package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.EventInfo;
import org.ivyinc.eventplanner.event.repository.EventInfoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventInfoService extends BaseService<EventInfo> {

    private final EventInfoRepository eventInfoRepository;

    @Override
    protected JpaRepository<EventInfo, Long> getRepository() {
        return eventInfoRepository;
    }
}
