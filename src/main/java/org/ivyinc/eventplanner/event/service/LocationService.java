package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.enums.LocationType;
import org.ivyinc.eventplanner.event.model.Location;
import org.ivyinc.eventplanner.event.repository.LocationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService extends BaseService<Location> {
    private final LocationRepository locationRepository;
    private final org.ivyinc.eventplanner.event.mapper.LocationMapper locationMapper;

    @Override
    protected JpaRepository<Location, Long> getRepository() {
        return locationRepository;
    }

    public Page<Location> findByType(LocationType type, Pageable pageable) {
        return locationRepository.findByType(type, pageable);
    }

    public Page<Location> findByCity(String city, Pageable pageable) {
        return locationRepository.findByCityIgnoreCase(city, pageable);
    }

    public Page<Location> search(String keyword, Pageable pageable) {
        return locationRepository.findByNameContainingIgnoreCaseOrCityContainingIgnoreCase(keyword, keyword, pageable);
    }

    public Location update(Long id, org.ivyinc.eventplanner.event.dto.LocationUpdateDto dto) {
        return locationRepository.findById(id).map(existing -> {
            locationMapper.updateLocationFromDto(dto, existing);
            return locationRepository.save(existing);
        }).orElseThrow(() -> new IllegalArgumentException("Location not found"));
    }
}
