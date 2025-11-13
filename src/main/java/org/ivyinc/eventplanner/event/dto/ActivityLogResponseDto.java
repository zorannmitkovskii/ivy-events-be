package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.util.UUID;

public record ActivityLogResponseDto(UUID id) implements BaseResponseDto {
}
