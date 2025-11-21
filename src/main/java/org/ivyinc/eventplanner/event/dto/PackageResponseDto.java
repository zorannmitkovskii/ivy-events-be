package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PackageResponseDto(
        UUID id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String name,
        String description,
        BigDecimal price) implements BaseResponseDto {
}
