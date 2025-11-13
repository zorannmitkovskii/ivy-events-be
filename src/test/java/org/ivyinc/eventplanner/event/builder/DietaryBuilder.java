package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.DietaryCreateDto;
import org.ivyinc.eventplanner.event.dto.DietaryResponseDto;
import org.ivyinc.eventplanner.event.dto.DietaryUpdateDto;
import org.ivyinc.eventplanner.event.model.Dietary;

import java.util.UUID;

public class DietaryBuilder implements DtoBuilder<DietaryCreateDto, DietaryUpdateDto, DietaryResponseDto> {

    public Dietary sampleDietary() {
        return Dietary.builder()
                .name("Standard")
                .description("Balanced diet including all major food groups.")
                .build();
    }

    public static Dietary veganDietary() {
        return Dietary.builder()
                .name("Vegan")
                .description("Excludes all animal products, including meat, dairy, and eggs.")
                .build();
    }

    public static Dietary vegetarianDietary() {
        return Dietary.builder()
                .name("Vegetarian")
                .description("Excludes meat and fish, but allows dairy and eggs.")
                .build();
    }

    @Override
    public DietaryCreateDto sampleCreateDto() {
        return new DietaryCreateDto("Standard",
                "Balanced diet including all major food groups.");
    }

    public static DietaryCreateDto veganDietaryCreateDto() {
        return new DietaryCreateDto("Vegan",
                "Excludes all animal products, including meat, dairy, and eggs.");
    }

    public static DietaryCreateDto vegetarianDietaryCreateDto() {
        return new DietaryCreateDto("Vegetarian",
                "Excludes meat and fish, but allows dairy and eggs.");
    }

    @Override
    public DietaryUpdateDto sampleUpdateDto() {
        return new DietaryUpdateDto("Standard",
                "Balanced diet including all major food groups.");
    }

    public static DietaryUpdateDto veganDietaryUpdateDto() {
        return new DietaryUpdateDto("Vegan",
                "Excludes all animal products, including meat, dairy, and eggs.");
    }

    public static DietaryUpdateDto vegetarianDietaryUpdateDto() {
        return new DietaryUpdateDto("Vegetarian",
                "Excludes meat and fish, but allows dairy and eggs.");
    }

    @Override
    public DietaryResponseDto sampleResponse(UUID id) {
        return new DietaryResponseDto(id, "Vegan", "No animal products or derivatives");
    }

    @Override
    public Class<DietaryResponseDto> responseDtoClass() {
        return DietaryResponseDto.class;
    }
}
