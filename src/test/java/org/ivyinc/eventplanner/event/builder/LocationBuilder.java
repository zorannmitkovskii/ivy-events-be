package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.enums.LocationType;
import org.ivyinc.eventplanner.event.model.Country;
import org.ivyinc.eventplanner.event.model.Location;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class LocationBuilder implements DtoBuilder<Location, LocationCreateDto, LocationUpdateDto, LocationResponseDto> {

    @Override
    public abstract Location sampleEntity();

    @Override
    public abstract LocationCreateDto sampleCreateDto();

    @Override
    public abstract LocationUpdateDto sampleUpdateDto();

    @Override
    public LocationResponseDto sampleCreateResponse(UUID id) {
        Location entity = sampleEntity();

        CountryResponseDto countryDto =
                new CountryResponseDto(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now(), "MK", "MKD", "North Macedonia", "🇲🇰");

        BigDecimal lat = entity.getLatitude() == null ? null : BigDecimal.valueOf(entity.getLatitude());
        BigDecimal lon = entity.getLongitude() == null ? null : BigDecimal.valueOf(entity.getLongitude());

        return new LocationResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now(),
                entity.getName(),
                entity.getType(),
                entity.getAddressLine(),
                entity.getCity(),
                countryDto,
                lat,
                lon,
                entity.getGoogleMapsUrl(),
                entity.getDescription(),
                entity.getCapacity(),
                entity.getNotes(),
                entity.getIsActive()
        );
    }

    @Override
    public LocationResponseDto sampleUpdateResponse(UUID id) {
        LocationUpdateDto dto = sampleUpdateDto();

        CountryResponseDto countryDto =
                new CountryResponseDto(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now(), "MK", "MKD", "North Macedonia", "🇲🇰");

        return new LocationResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now(),
                dto.name(),
                dto.type(),
                dto.addressLine(),
                dto.city(),
                countryDto,
                dto.latitude(),
                dto.longitude(),
                dto.googleMapsUrl(),
                dto.description(),
                dto.capacity(),
                dto.notes(),
                Boolean.TRUE
        );
    }

    @Override
    public Class<LocationResponseDto> responseDtoClass() {
        return LocationResponseDto.class;
    }

    // =====================================================================
    // 💍 WEDDING VENUE
    // =====================================================================
    public static class WeddingVenue extends LocationBuilder {

        @Override
        public Location sampleEntity() {
            Map<String, Object> hours = new HashMap<>();
            hours.put("mon-fri", "09:00-23:00");
            hours.put("sat-sun", "08:00-01:00");

            return Location.builder()
                    .name("Rose Garden Wedding Venue")
                    .type(LocationType.HALL)
                    .postalCode("1040")
                    .addressLine("Boulevard Partizanski Odredi 12")
                    .city("Skopje")
                    .country(new Country("MK", "MKD", "North Macedonia", "MK"))
                    .latitude(41.9995)
                    .longitude(21.4321)
                    .photoUrl("https://example.com/wedding-venue.jpg")
                    .googleMapsUrl("https://maps.google.com/?q=41.9995,21.4321")
                    .description("Romantic wedding venue with indoor and outdoor spaces.")
                    .capacity(300)
                    .openingHours(hours)
                    .notes("Includes a dedicated bridal suite.")
                    .contactId(UUID.randomUUID())
                    .isActive(true)
                    .build();
        }

        @Override
        public LocationCreateDto sampleCreateDto() {
            Map<String, Object> hours = new HashMap<>();
            hours.put("mon-fri", "09:00-23:00");
            hours.put("sat-sun", "08:00-01:00");

            return new LocationCreateDto(
                    "Rose Garden Wedding Venue",
                    LocationType.HALL,
                    "1040",
                    "Boulevard Partizanski Odredi 12",
                    "Skopje",
                    "MKD",
                    41.9995,
                    21.4321,
                    "https://example.com/wedding-venue.jpg",
                    "https://maps.google.com/?q=41.9995,21.4321",
                    "Romantic venue with indoor/outdoor spaces.",
                    300,
                    hours,
                    "Includes a dedicated bridal suite.",
                    UUID.randomUUID(),
                    true
            );
        }

        @Override
        public LocationUpdateDto sampleUpdateDto() {
            Map<String, Object> hours = new HashMap<>();
            hours.put("mon-fri", "10:00-22:00");

            return new LocationUpdateDto(
                    "Updated Rose Garden Venue",
                    LocationType.HOTEL,
                    "1041",
                    "Updated Street 55",
                    "Skopje",
                    "MKD",
                    new BigDecimal("42.0001"),
                    new BigDecimal("21.4331"),
                    "https://example.com/wedding-venue-updated.jpg",
                    "https://maps.google.com/?q=42.0001,21.4331",
                    "Updated description for wedding venue.",
                    350,
                    hours,
                    "Updated notes",
                    null,
                    true
            );
        }
    }

    // =====================================================================
    // 🏞 TEAM BUILDING RESORT
    // =====================================================================
    public static class TeamBuildingResort extends LocationBuilder {

        @Override
        public Location sampleEntity() {
            Map<String, Object> hours = new HashMap<>();
            hours.put("mon-sun", "07:00-20:00");

            return Location.builder()
                    .name("Mountain Adventure Resort")
                    .type(LocationType.OUTDOOR)
                    .postalCode("1300")
                    .addressLine("Lake Mladost Road")
                    .city("Veles")
                    .country(new Country("MK", "MKD", "North Macedonia", "MK"))
                    .latitude(41.7150)
                    .longitude(21.7733)
                    .photoUrl("https://example.com/team-building-resort.jpg")
                    .googleMapsUrl("https://maps.google.com/?q=41.7150,21.7733")
                    .description("Outdoor resort ideal for corporate team-building activities.")
                    .capacity(500)
                    .openingHours(hours)
                    .notes("Includes obstacle courses and zipline.")
                    .contactId(UUID.randomUUID())
                    .isActive(true)
                    .build();
        }

        @Override
        public LocationCreateDto sampleCreateDto() {
            Map<String, Object> hours = new HashMap<>();
            hours.put("mon-sun", "07:00-20:00");

            return new LocationCreateDto(
                    "Mountain Adventure Resort",
                    LocationType.OUTDOOR,
                    "1300",
                    "Lake Mladost Road",
                    "Veles",
                    "MKD",
                    41.7150,
                    21.7733,
                    "https://example.com/team-building-resort.jpg",
                    "https://maps.google.com/?q=41.7150,21.7733",
                    "Outdoor resort ideal for team-building events.",
                    500,
                    hours,
                    "Includes obstacle courses and zipline.",
                    UUID.randomUUID(),
                    true
            );
        }

        @Override
        public LocationUpdateDto sampleUpdateDto() {
            Map<String, Object> hours = new HashMap<>();
            hours.put("mon-sun", "08:00-19:00");

            return new LocationUpdateDto(
                    "Updated Mountain Resort",
                    LocationType.OTHER,
                    "1301",
                    "Updated Adventure Road",
                    "Veles",
                    "MKD",
                    new BigDecimal("41.7200"),
                    new BigDecimal("21.7800"),
                    "https://example.com/team-building-resort-updated.jpg",
                    "https://maps.google.com/?q=41.7200,21.7800",
                    "Updated team-building resort description.",
                    550,
                    hours,
                    "Updated notes",
                    null,
                    true
            );
        }
    }
}