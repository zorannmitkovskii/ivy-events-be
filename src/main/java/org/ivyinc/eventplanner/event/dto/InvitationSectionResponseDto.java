package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record InvitationSectionResponseDto(
        UUID id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) implements BaseResponseDto {
}
