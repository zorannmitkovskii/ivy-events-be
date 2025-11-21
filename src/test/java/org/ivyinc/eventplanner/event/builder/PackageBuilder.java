package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.PackageCreateDto;
import org.ivyinc.eventplanner.event.dto.PackageResponseDto;
import org.ivyinc.eventplanner.event.dto.PackageUpdateDto;
import org.ivyinc.eventplanner.event.model.Location;
import org.ivyinc.eventplanner.event.model.Package;
import org.ivyinc.eventplanner.event.model.Vendor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public abstract class PackageBuilder implements DtoBuilder<Package, PackageCreateDto, PackageUpdateDto, PackageResponseDto> {

    // ---------------------------------------------------------
    // Helpers: Vendor & Location builders for sample test data
    // ---------------------------------------------------------
    VendorBuilder.Photographer weddingVendorBuilder = new VendorBuilder.Photographer();
    VendorBuilder.Catering teamBuildingVendorBuilder = new VendorBuilder.Catering();

    LocationBuilder.WeddingVenue weddingLocationBuilder = new LocationBuilder.WeddingVenue();
    LocationBuilder.TeamBuildingResort teamBuildingLocationBuilder = new LocationBuilder.TeamBuildingResort();

    Vendor weddingVendor = weddingVendorBuilder.sampleEntity();
    Vendor teamBuildingVendor = teamBuildingVendorBuilder.sampleEntity();

    Location weddingLocation = weddingLocationBuilder.sampleEntity();
    Location teamBuildingLocation = teamBuildingLocationBuilder.sampleEntity();

    // ---------------------------------------------------------
    @Override
    public abstract Package sampleEntity();

    @Override
    public abstract PackageCreateDto sampleCreateDto();

    @Override
    public abstract PackageUpdateDto sampleUpdateDto();

    @Override
    public abstract PackageResponseDto sampleCreateResponse(UUID id);

    @Override
    public abstract PackageResponseDto sampleUpdateResponse(UUID id);

    @Override
    public Class<PackageResponseDto> responseDtoClass() {
        return PackageResponseDto.class;
    }

    // ========================================================================
    // 💍 WEDDING PACKAGE BUILDER
    // ========================================================================
    public static class WeddingPackage extends PackageBuilder {

        @Override
        public Package sampleEntity() {
            return Package.builder()
                    .name("Wedding Premium Package")
                    .description("Full wedding service including photography, catering, and venue.")
                    .price(BigDecimal.valueOf(3500))
                    .priceCurrency("EUR")
                    .videoUrl("https://video.example.com/wedding_premium.mp4")
                    .vendors(List.of(weddingVendor))
                    .locations(List.of(weddingLocation))
                    .build();
        }

        @Override
        public PackageCreateDto sampleCreateDto() {
            return new PackageCreateDto(
                    "Wedding Premium Package",
                    "Full wedding service including photography, catering, and venue.",
                    BigDecimal.valueOf(3500),
                    "EUR",
                    "https://video.example.com/wedding_premium.mp4",
                    List.of(weddingVendorBuilder.sampleEntity().getId()),
                    List.of(weddingLocationBuilder.sampleEntity().getId())
            );
        }

        @Override
        public PackageUpdateDto sampleUpdateDto() {
            return new PackageUpdateDto(
                    "Wedding Premium Package Updated",
                    "Updated description for wedding premium package.",
                    BigDecimal.valueOf(3800),
                    List.of(weddingVendorBuilder.sampleEntity().getId()),
                    List.of(weddingLocationBuilder.sampleEntity().getId())
            );
        }

        @Override
        public PackageResponseDto sampleCreateResponse(UUID id) {
            return new PackageResponseDto(
                    id,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    "Wedding Premium Package",
                    "Full wedding service including photography, catering, and venue.",
                    BigDecimal.valueOf(3500)
            );
        }

        @Override
        public PackageResponseDto sampleUpdateResponse(UUID id) {
            return new PackageResponseDto(
                    id,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    "Wedding Premium Package Updated",
                    "Updated description for wedding premium package.",
                    BigDecimal.valueOf(3800)
            );
        }
    }

    // ========================================================================
    // 🏢 TEAM BUILDING PACKAGE BUILDER
    // ========================================================================
    public static class TeamBuildingPackage extends PackageBuilder {

        @Override
        public Package sampleEntity() {
            return Package.builder()
                    .name("Corporate Team Building Package")
                    .description("Outdoor and indoor team activities, catering, and full event support.")
                    .price(BigDecimal.valueOf(1800))
                    .priceCurrency("EUR")
                    .videoUrl("https://video.example.com/team_building.mp4")
                    .vendors(List.of(teamBuildingVendor))
                    .locations(List.of(teamBuildingLocation))
                    .build();
        }

        @Override
        public PackageCreateDto sampleCreateDto() {
            return new PackageCreateDto(
                    "Corporate Team Building Package",
                    "Outdoor and indoor team activities, catering, and full event support.",
                    BigDecimal.valueOf(1800),
                    "EUR",
                    "https://video.example.com/team_building.mp4",
                    List.of(teamBuildingVendorBuilder.sampleEntity().getId()),
                    List.of(teamBuildingLocationBuilder.sampleEntity().getId())
            );
        }

        @Override
        public PackageUpdateDto sampleUpdateDto() {
            return new PackageUpdateDto(
                    "Corporate Team Building Package Updated",
                    "Updated description for corporate team building package.",
                    BigDecimal.valueOf(2000),
                    List.of(teamBuildingVendorBuilder.sampleEntity().getId()),
                    List.of(teamBuildingLocationBuilder.sampleEntity().getId())
            );
        }

        @Override
        public PackageResponseDto sampleCreateResponse(UUID id) {
            return new PackageResponseDto(
                    id,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    "Corporate Team Building Package",
                    "Outdoor and indoor team activities, catering, and full event support.",
                    BigDecimal.valueOf(1800)
            );
        }

        @Override
        public PackageResponseDto sampleUpdateResponse(UUID id) {
            return new PackageResponseDto(
                    id,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    "Corporate Team Building Package Updated",
                    "Updated description for corporate team building package.",
                    BigDecimal.valueOf(2000)
            );
        }
    }
}

