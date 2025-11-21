package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.event.enums.LocationType;

import java.util.Map;
import java.util.UUID;

public record LocationCreateDto(
        String name,
        LocationType type,
        String postalCode,
        String addressLine,
        String city,
        String countryIso3,
        Double latitude,
        Double longitude,
        String photoUrl,
        String googleMapsUrl,
        String description,
        Integer capacity,
        Map<String, Object> openingHours,
        String notes,
        UUID contactId,
        Boolean isActive
) {}
