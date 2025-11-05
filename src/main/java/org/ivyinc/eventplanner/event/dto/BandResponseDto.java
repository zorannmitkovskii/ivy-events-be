package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseResponseDto;

import java.util.List;
import java.util.UUID;

public record BandResponseDto(
        UUID id,
        String name,
        String description,
        String musicType,
        String videoUrl,
        String providerId,
        List<String> songList,
        ContactResponseDto contact,
        Double price,
        Double rating,
        String notes,
        List<PackageResponseDto> packages
) implements BaseResponseDto {
}
