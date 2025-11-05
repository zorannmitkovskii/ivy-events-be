package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.util.UUID;

public record ContactResponseDto(
        UUID id,
        String name,
        String email,
        String phone
) implements BaseResponseDto {
}
