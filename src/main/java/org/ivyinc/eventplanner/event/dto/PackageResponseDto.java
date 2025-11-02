package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.util.UUID;

public record PackageResponseDto(
        UUID id,
        String name,
        String description,
        Double price) implements BaseResponseDto {
}
