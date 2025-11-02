package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;

import java.util.UUID;

public record PackageUpdateDto(
        String name,
        String description,
        Double price,
        UUID vendorId,
        UUID bandId) implements BaseUpdateRequestDto {
}
