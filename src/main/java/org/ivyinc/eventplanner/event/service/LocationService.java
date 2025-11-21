package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.LocationCreateDto;
import org.ivyinc.eventplanner.event.dto.LocationResponseDto;
import org.ivyinc.eventplanner.event.dto.LocationUpdateDto;
import org.ivyinc.eventplanner.event.mapper.LocationMapper;
import org.ivyinc.eventplanner.event.model.Country;
import org.ivyinc.eventplanner.event.model.Location;
import org.ivyinc.eventplanner.event.repository.CountryRepository;
import org.ivyinc.eventplanner.event.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
public class LocationService extends BaseServiceImpl<Location, LocationCreateDto, LocationUpdateDto, LocationResponseDto, LocationRepository> {
    private final CountryRepository countryRepository;

    public LocationService(LocationRepository repository, LocationMapper mapper, CountryRepository countryRepository) {
        super(repository, mapper);
        this.countryRepository = countryRepository;
    }

    @Override
    public LocationResponseDto create(LocationCreateDto dto) {
        Location entity = mapper.toEntity(dto);
        if (dto.countryIso3() != null && !dto.countryIso3().isBlank()) {
            entity.setCountry(resolveCountry(dto.countryIso3()));
        }
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public LocationResponseDto update(String id, LocationUpdateDto dto) {
        Location entity = repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
        mapper.updateEntity(entity, dto);
        if (dto.country() != null && !dto.country().isBlank()) {
            entity.setCountry(resolveCountry(dto.country()));
        }
        return mapper.toResponse(repository.save(entity));
    }

    private Country resolveCountry(String iso3) {
        String code = iso3.trim().toUpperCase(Locale.ROOT);
        return countryRepository.findByIso3(code)
                .orElseThrow(() -> new IllegalArgumentException("Country not found for ISO3: " + code));
    }
}
