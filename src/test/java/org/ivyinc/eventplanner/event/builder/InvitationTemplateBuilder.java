package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.model.InvitationTemplate;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class InvitationTemplateBuilder implements DtoBuilder<
        InvitationTemplate,
        InvitationTemplateCreateDto,
        InvitationTemplateUpdateDto,
        InvitationTemplateResponseDto
        > {

    @Override
    public InvitationTemplate sampleEntity() {
        return InvitationTemplate.builder()
                .name("Elegant Wedding Template")
                .templatePath("/templates/wedding/elegant.html")
                .previewImage("/images/templates/wedding/elegant.png")
                .description("A classic, elegant design suitable for weddings.")
                .sections(sampleSections())
                .themeColor("#C0A080")
                .fontStyle("Serif")
                .backgroundImageUrl("https://cdn.example.com/bg/wedding-elegant.jpg")
                .language("en")
                .templateVersion(1)
                .editable(true)
                .build();
    }

    private Map<String, Object> sampleSections() {
        Map<String, Object> sections = new LinkedHashMap<>();
        sections.put("header", Map.of("title", "You're Invited", "subtitle", "Join us for our special day"));
        sections.put("details", Map.of("date", "2025-06-15", "venue", "Sunset Gardens"));
        sections.put("rsvp", Map.of("enabled", true, "deadline", "2025-05-20"));
        return sections;
    }

    @Override
    public InvitationTemplateCreateDto sampleCreateDto() {
        return new InvitationTemplateCreateDto(
                "Elegant Wedding Template",
                "/templates/wedding/elegant.html",
                "/images/templates/wedding/elegant.png",
                "A classic, elegant design suitable for weddings.",
                sampleSections(),
                "#C0A080",
                "Serif",
                "https://cdn.example.com/bg/wedding-elegant.jpg",
                "en",
                1,
                true
        );
    }

    @Override
    public InvitationTemplateUpdateDto sampleUpdateDto() {
        Map<String, Object> updatedSections = new LinkedHashMap<>(sampleSections());
        updatedSections.put("details", Map.of("date", "2025-07-01", "venue", "Lakeside Hall"));
        return new InvitationTemplateUpdateDto(
                "Elegant Wedding Template v2",
                "/templates/wedding/elegant-v2.html",
                "/images/templates/wedding/elegant-v2.png",
                "Updated layout with refined typography.",
                updatedSections,
                "#A080C0",
                "Sans-Serif",
                "https://cdn.example.com/bg/wedding-elegant-v2.jpg",
                "en",
                2,
                true
        );
    }

    @Override
    public InvitationTemplateResponseDto sampleCreateResponse(UUID id) {
        var c = sampleCreateDto();
        return new InvitationTemplateResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now(),
                c.name(),
                c.templatePath(),
                c.previewImage(),
                c.description(),
                c.sections(),
                c.themeColor(),
                c.fontStyle(),
                c.backgroundImageUrl(),
                c.language(),
                c.templateVersion(),
                c.editable()
        );
    }

    @Override
    public InvitationTemplateResponseDto sampleUpdateResponse(UUID id) {
        var u = sampleUpdateDto();
        return new InvitationTemplateResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now(),
                u.name(),
                u.templatePath(),
                u.previewImage(),
                u.description(),
                u.sections(),
                u.themeColor(),
                u.fontStyle(),
                u.backgroundImageUrl(),
                u.language(),
                u.templateVersion(),
                u.editable()
        );
    }

    @Override
    public Class<InvitationTemplateResponseDto> responseDtoClass() {
        return InvitationTemplateResponseDto.class;
    }
}
