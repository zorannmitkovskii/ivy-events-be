package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.InvitationSectionCreateDto;
import org.ivyinc.eventplanner.event.dto.InvitationSectionResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationSectionUpdateDto;
import org.ivyinc.eventplanner.event.model.InvitationSection;

import java.time.LocalDateTime;
import java.util.UUID;

public class InvitationSectionBuilder implements DtoBuilder<
        InvitationSection,
        InvitationSectionCreateDto,
        InvitationSectionUpdateDto,
        InvitationSectionResponseDto
        > {

    @Override
    public InvitationSection sampleEntity() {
        return InvitationSection.builder()
                .name("Header")
                .sectionType("HEADER")
                .path("/sections/header.html")
                .orderIndex(1)
                .isRequired(true)
                .build();
    }

    @Override
    public InvitationSectionCreateDto sampleCreateDto() {
        return new InvitationSectionCreateDto();
        // Currently empty, aligned with project DTO definition
    }

    @Override
    public InvitationSectionUpdateDto sampleUpdateDto() {
        return new InvitationSectionUpdateDto();
        // Currently empty, aligned with project DTO definition
    }

    @Override
    public InvitationSectionResponseDto sampleCreateResponse(UUID id) {
        return new InvitationSectionResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public InvitationSectionResponseDto sampleUpdateResponse(UUID id) {
        return new InvitationSectionResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public Class<InvitationSectionResponseDto> responseDtoClass() {
        return InvitationSectionResponseDto.class;
    }
}
