package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.event.enums.LocationType;

import java.math.BigDecimal;

public record LocationCreateDto(
        String name,
        LocationType type,
        String addressLine,
        String city,
        String country, // ISO3 code (e.g., "USA", "FRA")
        BigDecimal latitude,
        BigDecimal longitude,
        String googleMapsUrl,
        String description,
        Integer capacity,
        String notes
) {
}
