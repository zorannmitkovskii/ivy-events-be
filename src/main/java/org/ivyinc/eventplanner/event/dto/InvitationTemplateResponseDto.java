package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public record InvitationTemplateResponseDto(
        UUID id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String name,
        String templatePath,
        String previewImage,
        String description,
        Map<String, Object> sections,
        String themeColor,
        String fontStyle,
        String backgroundImageUrl,
        String language,
        Integer templateVersion,
        Boolean editable
) implements BaseResponseDto {
}
