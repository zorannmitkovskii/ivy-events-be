package org.ivyinc.eventplanner.event.dto;

import java.util.List;

public record FormCreateDto(
        String name,
        Integer version,
        List<FormFieldCreateDto> fields
) {}
