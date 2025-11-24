package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.LocationBuilder;
import org.ivyinc.eventplanner.event.dto.LocationCreateDto;
import org.ivyinc.eventplanner.event.dto.LocationResponseDto;
import org.ivyinc.eventplanner.event.dto.LocationUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class LocationControllerIT extends BaseCrudControllerIT<LocationCreateDto, LocationUpdateDto, LocationResponseDto> {

    private final LocationBuilder.WeddingVenue builder = new LocationBuilder.WeddingVenue();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected LocationCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected LocationUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(LocationResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
        });
    }

    @Override
    protected void assertUpdateAssertions(LocationResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
        });
    }

    @Override
    protected Class<LocationResponseDto> getResponseDtoClass() {
        return LocationResponseDto.class;
    }

    @Override
    protected UUID extractId(LocationResponseDto dto) {
        return dto.id();
    }
}
