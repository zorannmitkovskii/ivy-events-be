package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ContactResponseDto(
        UUID id,
        String name,
        String email,
        String phone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) implements BaseResponseDto {
}
