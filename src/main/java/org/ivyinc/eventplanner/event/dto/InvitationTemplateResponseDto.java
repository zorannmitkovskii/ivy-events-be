package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.util.UUID;

public record InvitationTemplateResponseDto(
        UUID id,
        String name,
        String templatePath,
        String previewImage,
        String description,
        String sections,
        String themeColor,
        String fontStyle,
        String backgroundImageUrl,
        String language,
        Integer templateVersion,
        Boolean editable
) implements BaseResponseDto {
}
