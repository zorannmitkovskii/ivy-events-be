package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventCategoryResponseDto(UUID id,
                                       String name,
                                       String description,
                                       LocalDateTime createdAt,
                                       LocalDateTime updatedAt) implements BaseResponseDto {
}
