package org.ivyinc.eventplanner.event.dto;

import java.util.UUID;

public record FieldOptionUpdateDto(
        UUID formId,
        String value,
        Integer orderIndex
) {
}
