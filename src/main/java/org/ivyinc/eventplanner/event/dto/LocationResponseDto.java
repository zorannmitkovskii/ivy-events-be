package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.event.enums.LocationType;
import java.math.BigDecimal;
import java.util.UUID;
import org.ivyinc.eventplanner.common.BaseResponseDto;
import org.ivyinc.eventplanner.event.model.Country;

public record LocationResponseDto(
        UUID id,
        String name,
        LocationType type,
        String addressLine,
        String city,
        Country country,
        BigDecimal latitude,
        BigDecimal longitude,
        String googleMapsUrl,
        String description,
        Integer capacity,
        String notes,
        Boolean active
) implements BaseResponseDto {
}
