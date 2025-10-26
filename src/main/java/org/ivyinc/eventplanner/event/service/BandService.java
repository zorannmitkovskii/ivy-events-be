package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.Band;
import org.ivyinc.eventplanner.event.repository.BandRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BandService extends BaseService<Band> {

    private final BandRepository bandRepository;

    @Override
    protected BaseRepository<Band> getRepository() {
        return bandRepository;
    }
}
