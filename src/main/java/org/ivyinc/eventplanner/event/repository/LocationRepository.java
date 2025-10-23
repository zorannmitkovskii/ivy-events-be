package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.enums.LocationType;
import org.ivyinc.eventplanner.event.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LocationRepository extends BaseRepository<Location> {
    Page<Location> findByType(LocationType type, Pageable pageable);

    Page<Location> findByCityIgnoreCase(String city, Pageable pageable);

    Page<Location> findByNameContainingIgnoreCaseOrCityContainingIgnoreCase(
            String name, String city, Pageable pageable
    );
}
