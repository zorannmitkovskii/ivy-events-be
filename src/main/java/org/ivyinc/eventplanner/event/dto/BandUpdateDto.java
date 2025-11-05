package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;

import java.util.List;

public record BandUpdateDto(
        String name,
        String description,
        String musicType,
        String videoUrl,
        String providerId,
        List<String> songList,
        ContactUpdateDto contact,
        Double price,
        Double rating,
        String notes,
        List<PackageUpdateDto> packages
) implements BaseUpdateRequestDto {
}
