package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.event.enums.LocationType;

import java.math.BigDecimal;
import java.util.Map;

public record LocationUpdateDto(
        String name,
        LocationType type,
        String postalCode,
        String addressLine,
        String city,
        String country,
        BigDecimal latitude,
        BigDecimal longitude,
        String photoUrl,
        String googleMapsUrl,
        String description,
        Integer capacity,
        Map<String, Object> openingHours,
        String notes,
        ContactUpdateDto contactUpdateDto,
        Boolean isActive
) {
}
