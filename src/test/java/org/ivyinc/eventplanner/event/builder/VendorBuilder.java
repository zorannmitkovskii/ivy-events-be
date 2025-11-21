package org.ivyinc.eventplanner.event.builder;

import lombok.AllArgsConstructor;
import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.enums.VendorType;
import org.ivyinc.eventplanner.event.enums.AvailabilityStatus;
import org.ivyinc.eventplanner.event.model.Contact;
import org.ivyinc.eventplanner.event.model.Vendor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public abstract class VendorBuilder implements DtoBuilder<Vendor, VendorCreateDto, VendorUpdateDto, VendorResponseDto> {

    // ============================================================
    // Shared Contact Data for Test Fixtures
    // ============================================================
    protected final UUID weddingContactId = UUID.randomUUID();
    protected final UUID teamBuildingContactId = UUID.randomUUID();

    protected final ContactBuilder.WeddingContact weddingContactBuilder = new ContactBuilder.WeddingContact();
    protected final ContactBuilder.TeamBuildingContact teamBuildingContactBuilder = new ContactBuilder.TeamBuildingContact();

    protected final Contact weddingContact = weddingContactBuilder.sampleEntity();
    protected final Contact teamBuildingContact = teamBuildingContactBuilder.sampleEntity();

    protected final ContactResponseDto weddingContactResponse =
            weddingContactBuilder.sampleCreateResponse(weddingContactId);

    protected final ContactResponseDto teamBuildingContactResponse =
            teamBuildingContactBuilder.sampleCreateResponse(teamBuildingContactId);

    // ------------------------------------------------------------
    @Override
    public abstract Vendor sampleEntity();

    @Override
    public abstract VendorCreateDto sampleCreateDto();

    @Override
    public abstract VendorUpdateDto sampleUpdateDto();

    @Override
    public abstract VendorResponseDto sampleCreateResponse(UUID id);

    @Override
    public abstract VendorResponseDto sampleUpdateResponse(UUID id);

    @Override
    public Class<VendorResponseDto> responseDtoClass() {
        return VendorResponseDto.class;
    }


    // ======================================================================
    // 💍 WEDDING VENDOR → Wedding Photographer
    // ======================================================================
    public static class WeddingVendor extends VendorBuilder {

        @Override
        public Vendor sampleEntity() {
            return Vendor.builder()
                    .name("DreamLight Photography")
                    .type(VendorType.PHOTOGRAPHER)
                    .contact(weddingContact)
                    .website("https://dreamlight-photo.com")
                    .instagramUrl("https://instagram.com/dreamlight.photo")
                    .serviceArea("Skopje, Ohrid, Bitola")
                    .availabilityStatus(AvailabilityStatus.AVAILABLE)
                    .contractUrl("https://cdn.ivyinc.com/contracts/dreamlight.pdf")
                    .rating(4.9)
                    .isActive(true)
                    .packages(new ArrayList<>()) // filled in tests
                    .build();
        }

        @Override
        public VendorCreateDto sampleCreateDto() {
            return new VendorCreateDto(
                    "DreamLight Photography",
                    VendorType.PHOTOGRAPHER,
                    weddingContactId,
                    "https://dreamlight-photo.com",
                    "https://instagram.com/dreamlight.photo",
                    "Skopje, Ohrid, Bitola",
                    AvailabilityStatus.AVAILABLE,
                    "https://cdn.ivyinc.com/contracts/dreamlight.pdf",
                    4.9,
                    true
            );
        }

        @Override
        public VendorUpdateDto sampleUpdateDto() {
            return new VendorUpdateDto(
                    "DreamLight Photo Studio (Updated)",
                    VendorType.PHOTOGRAPHER,
                    weddingContactId,
                    "https://dreamlight-photo-updated.com",
                    "https://instagram.com/dreamlight.photo.updated",
                    "All Macedonia",
                    AvailabilityStatus.BUSY,
                    "https://cdn.ivyinc.com/contracts/dreamlight_updated.pdf",
                    4.8,
                    true
            );
        }

        @Override
        public VendorResponseDto sampleCreateResponse(UUID id) {
            return new VendorResponseDto(
                    id,
                    "DreamLight Photography",
                    VendorType.PHOTOGRAPHER,
                    weddingContactResponse,
                    "https://dreamlight-photo.com",
                    "https://instagram.com/dreamlight.photo",
                    "Skopje, Ohrid, Bitola",
                    AvailabilityStatus.AVAILABLE,
                    "https://cdn.ivyinc.com/contracts/dreamlight.pdf",
                    4.9,
                    true,
                    new ArrayList<>(), // packages
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public VendorResponseDto sampleUpdateResponse(UUID id) {
            VendorUpdateDto dto = sampleUpdateDto();

            return new VendorResponseDto(
                    id,
                    dto.name(),
                    dto.type(),
                    weddingContactResponse,
                    dto.website(),
                    dto.instagramUrl(),
                    dto.serviceArea(),
                    dto.availabilityStatus(),
                    dto.contractUrl(),
                    dto.rating(),
                    dto.isActive(),
                    new ArrayList<>(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }
    public static class Photographer extends VendorBuilder {

        @Override
        public Vendor sampleEntity() {
            return Vendor.builder()
                    .name("DreamLight Photography")
                    .type(VendorType.PHOTOGRAPHER)
                    .contact(weddingContact)
                    .website("https://dreamlight-photo.com")
                    .instagramUrl("https://instagram.com/dreamlight.photo")
                    .serviceArea("Skopje, Ohrid, Bitola")
                    .availabilityStatus(AvailabilityStatus.AVAILABLE)
                    .contractUrl("https://cdn.ivyinc.com/contracts/dreamlight.pdf")
                    .rating(4.9)
                    .isActive(true)
                    .packages(new ArrayList<>()) // filled in tests
                    .build();
        }

        @Override
        public VendorCreateDto sampleCreateDto() {
            return new VendorCreateDto(
                    "DreamLight Photography",
                    VendorType.PHOTOGRAPHER,
                    weddingContactId,
                    "https://dreamlight-photo.com",
                    "https://instagram.com/dreamlight.photo",
                    "Skopje, Ohrid, Bitola",
                    AvailabilityStatus.AVAILABLE,
                    "https://cdn.ivyinc.com/contracts/dreamlight.pdf",
                    4.9,
                    true
            );
        }

        @Override
        public VendorUpdateDto sampleUpdateDto() {
            return new VendorUpdateDto(
                    "DreamLight Photo Studio (Updated)",
                    VendorType.PHOTOGRAPHER,
                    weddingContactId,
                    "https://dreamlight-photo-updated.com",
                    "https://instagram.com/dreamlight.photo.updated",
                    "All Macedonia",
                    AvailabilityStatus.BUSY,
                    "https://cdn.ivyinc.com/contracts/dreamlight_updated.pdf",
                    4.8,
                    true
            );
        }

        @Override
        public VendorResponseDto sampleCreateResponse(UUID id) {
            return new VendorResponseDto(
                    id,
                    "DreamLight Photography",
                    VendorType.PHOTOGRAPHER,
                    weddingContactResponse,
                    "https://dreamlight-photo.com",
                    "https://instagram.com/dreamlight.photo",
                    "Skopje, Ohrid, Bitola",
                    AvailabilityStatus.AVAILABLE,
                    "https://cdn.ivyinc.com/contracts/dreamlight.pdf",
                    4.9,
                    true,
                    new ArrayList<>(), // packages
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public VendorResponseDto sampleUpdateResponse(UUID id) {
            VendorUpdateDto dto = sampleUpdateDto();

            return new VendorResponseDto(
                    id,
                    dto.name(),
                    dto.type(),
                    weddingContactResponse,
                    dto.website(),
                    dto.instagramUrl(),
                    dto.serviceArea(),
                    dto.availabilityStatus(),
                    dto.contractUrl(),
                    dto.rating(),
                    dto.isActive(),
                    new ArrayList<>(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }


    // ======================================================================
    // 🏢 TEAM BUILDING VENDOR → Catering Vendor
    // ======================================================================
    public static class TeamBuildingVendor extends VendorBuilder {

        @Override
        public Vendor sampleEntity() {
            return Vendor.builder()
                    .name("ProCatering Services")
                    .type(VendorType.CATERING)
                    .contact(teamBuildingContact)
                    .website("https://procatering.com")
                    .instagramUrl("https://instagram.com/pro.catering")
                    .serviceArea("Skopje Region")
                    .availabilityStatus(AvailabilityStatus.AVAILABLE)
                    .contractUrl("https://cdn.ivyinc.com/contracts/procatering.pdf")
                    .rating(4.6)
                    .isActive(true)
                    .packages(new ArrayList<>()) // filled in tests
                    .build();
        }

        @Override
        public VendorCreateDto sampleCreateDto() {
            return new VendorCreateDto(
                    "ProCatering Services",
                    VendorType.CATERING,
                    teamBuildingContactId,
                    "https://procatering.com",
                    "https://instagram.com/pro.catering",
                    "Skopje Region",
                    AvailabilityStatus.AVAILABLE,
                    "https://cdn.ivyinc.com/contracts/procatering.pdf",
                    4.6,
                    true
            );
        }

        @Override
        public VendorUpdateDto sampleUpdateDto() {
            return new VendorUpdateDto(
                    "ProCatering Services Updated",
                    VendorType.CATERING,
                    teamBuildingContactId,
                    "https://procatering-updated.com",
                    "https://instagram.com/pro.catering.updated",
                    "All Macedonia",
                    AvailabilityStatus.BUSY,
                    "https://cdn.ivyinc.com/contracts/procatering_updated.pdf",
                    4.7,
                    true
            );
        }

        @Override
        public VendorResponseDto sampleCreateResponse(UUID id) {
            return new VendorResponseDto(
                    id,
                    "ProCatering Services",
                    VendorType.CATERING,
                    teamBuildingContactResponse,
                    "https://procatering.com",
                    "https://instagram.com/pro.catering",
                    "Skopje Region",
                    AvailabilityStatus.AVAILABLE,
                    "https://cdn.ivyinc.com/contracts/procatering.pdf",
                    4.6,
                    true,
                    new ArrayList<>(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public VendorResponseDto sampleUpdateResponse(UUID id) {
            VendorUpdateDto dto = sampleUpdateDto();

            return new VendorResponseDto(
                    id,
                    dto.name(),
                    dto.type(),
                    teamBuildingContactResponse,
                    dto.website(),
                    dto.instagramUrl(),
                    dto.serviceArea(),
                    dto.availabilityStatus(),
                    dto.contractUrl(),
                    dto.rating(),
                    dto.isActive(),
                    new ArrayList<>(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }
    public static class Catering extends VendorBuilder {

        @Override
        public Vendor sampleEntity() {
            return Vendor.builder()
                    .name("ProCatering Services")
                    .type(VendorType.CATERING)
                    .contact(teamBuildingContact)
                    .website("https://procatering.com")
                    .instagramUrl("https://instagram.com/pro.catering")
                    .serviceArea("Skopje Region")
                    .availabilityStatus(AvailabilityStatus.AVAILABLE)
                    .contractUrl("https://cdn.ivyinc.com/contracts/procatering.pdf")
                    .rating(4.6)
                    .isActive(true)
                    .packages(new ArrayList<>()) // filled in tests
                    .build();
        }

        @Override
        public VendorCreateDto sampleCreateDto() {
            return new VendorCreateDto(
                    "ProCatering Services",
                    VendorType.CATERING,
                    teamBuildingContactId,
                    "https://procatering.com",
                    "https://instagram.com/pro.catering",
                    "Skopje Region",
                    AvailabilityStatus.AVAILABLE,
                    "https://cdn.ivyinc.com/contracts/procatering.pdf",
                    4.6,
                    true
            );
        }

        @Override
        public VendorUpdateDto sampleUpdateDto() {
            return new VendorUpdateDto(
                    "ProCatering Services Updated",
                    VendorType.CATERING,
                    teamBuildingContactId,
                    "https://procatering-updated.com",
                    "https://instagram.com/pro.catering.updated",
                    "All Macedonia",
                    AvailabilityStatus.BUSY,
                    "https://cdn.ivyinc.com/contracts/procatering_updated.pdf",
                    4.7,
                    true
            );
        }

        @Override
        public VendorResponseDto sampleCreateResponse(UUID id) {
            return new VendorResponseDto(
                    id,
                    "ProCatering Services",
                    VendorType.CATERING,
                    teamBuildingContactResponse,
                    "https://procatering.com",
                    "https://instagram.com/pro.catering",
                    "Skopje Region",
                    AvailabilityStatus.AVAILABLE,
                    "https://cdn.ivyinc.com/contracts/procatering.pdf",
                    4.6,
                    true,
                    new ArrayList<>(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public VendorResponseDto sampleUpdateResponse(UUID id) {
            VendorUpdateDto dto = sampleUpdateDto();

            return new VendorResponseDto(
                    id,
                    dto.name(),
                    dto.type(),
                    teamBuildingContactResponse,
                    dto.website(),
                    dto.instagramUrl(),
                    dto.serviceArea(),
                    dto.availabilityStatus(),
                    dto.contractUrl(),
                    dto.rating(),
                    dto.isActive(),
                    new ArrayList<>(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }
}


