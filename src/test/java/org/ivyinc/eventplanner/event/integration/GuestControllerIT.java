package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.GuestBuilder;
import org.ivyinc.eventplanner.event.dto.GuestCreateDto;
import org.ivyinc.eventplanner.event.dto.GuestResponseDto;
import org.ivyinc.eventplanner.event.dto.GuestUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class GuestControllerIT extends BaseCrudControllerIT<GuestCreateDto, GuestUpdateDto, GuestResponseDto> {

    private final GuestBuilder.WeddingGuest1 builder = new GuestBuilder.WeddingGuest1();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected GuestCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected GuestUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(GuestResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().names().getFirst());
        });
    }

    @Override
    protected void assertUpdateAssertions(GuestResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().names().getFirst());
        });
    }

    @Override
    protected Class<GuestResponseDto> getResponseDtoClass() {
        return GuestResponseDto.class;
    }

    @Override
    protected UUID extractId(GuestResponseDto dto) {
        return dto.id();
    }
}
