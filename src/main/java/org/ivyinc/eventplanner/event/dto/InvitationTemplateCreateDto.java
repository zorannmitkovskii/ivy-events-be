package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.util.Map;

public record InvitationTemplateCreateDto(
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
) implements BaseCreateRequestDto {
}
