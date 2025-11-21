package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record PackageUpdateDto(
        String name,
        String description,
        BigDecimal price,
        List<UUID> vendorIds,
        List<UUID> locationIds) implements BaseUpdateRequestDto {
}
