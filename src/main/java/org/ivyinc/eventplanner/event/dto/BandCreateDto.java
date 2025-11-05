package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.util.List;

public record BandCreateDto(
        String name,
        String description,
        String musicType,
        String videoUrl,
        String providerId,
        List<String> songList,
        ContactCreateDto contact,
        Double price,
        Double rating,
        String notes,
        List<PackageCreateDto> packages
) implements BaseCreateRequestDto {
}
