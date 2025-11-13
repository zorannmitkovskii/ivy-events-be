package org.ivyinc.eventplanner.event.dto;

public record InvitationTemplateUpdateRequestDto(
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
) {
}
