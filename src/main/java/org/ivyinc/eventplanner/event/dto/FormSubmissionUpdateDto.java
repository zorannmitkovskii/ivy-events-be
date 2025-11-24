package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;

public record FormSubmissionUpdateDto(
        String name,
        String description
) implements BaseUpdateRequestDto {
}
