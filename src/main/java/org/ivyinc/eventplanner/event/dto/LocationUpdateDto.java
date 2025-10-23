package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.event.enums.LocationType;

/**
 * Immutable DTO for Location updates and creation.
 * Using record for cleaner, type-safe data transport.
 */
public record LocationUpdateDto(
        String name,
        LocationType type,
        String address,
        String gmapsLink,
        Double latitude,
        Double longitude,
        String phoneNumber,
        String website,
        String city,
        String country,
        String notes
) {}

