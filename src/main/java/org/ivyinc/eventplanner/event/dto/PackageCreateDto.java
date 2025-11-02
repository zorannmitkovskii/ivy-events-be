package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.util.UUID;

public record PackageCreateDto(
        String name,
        String description,
        Double price,
        UUID vendorId,
        UUID bandId
) implements BaseCreateRequestDto {
}
