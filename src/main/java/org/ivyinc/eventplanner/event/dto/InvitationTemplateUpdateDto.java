package org.ivyinc.eventplanner.event.dto;

import java.util.Map;

public record InvitationTemplateUpdateDto(
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
) {
}
