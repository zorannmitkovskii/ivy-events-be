package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.util.Map;
import java.util.UUID;

public record EventInfoCreateDto(
        UUID formId,
        String note,
        Integer version,
        String contactPerson,
        String phoneNumber,
        String email,
        Map<String, Object> agenda,
        Map<String, Object> tags
) implements BaseCreateRequestDto {
}
