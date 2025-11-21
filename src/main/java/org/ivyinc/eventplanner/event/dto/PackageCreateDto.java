package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record PackageCreateDto(
        String name,
        String description,
        BigDecimal price,
        String priceCurrency,
        String videoUrl,
        List<UUID> vendorIds,
        List<UUID> locationIds
) implements BaseCreateRequestDto {
}
