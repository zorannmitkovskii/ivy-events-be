package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.model.Country;

import java.util.Optional;

public interface CountryRepository extends BaseRepository<Country> {
    Optional<Country> findByIso3(String iso3);
}
