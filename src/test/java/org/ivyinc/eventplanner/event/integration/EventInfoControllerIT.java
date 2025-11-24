package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.EventInfoBuilder;
import org.ivyinc.eventplanner.event.dto.EventInfoCreateDto;
import org.ivyinc.eventplanner.event.dto.EventInfoResponseDto;
import org.ivyinc.eventplanner.event.dto.EventInfoUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class EventInfoControllerIT extends BaseCrudControllerIT<EventInfoCreateDto, EventInfoUpdateDto, EventInfoResponseDto> {

    private final EventInfoBuilder builder = new EventInfoBuilder();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected EventInfoCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected EventInfoUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(EventInfoResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
        });
    }

    @Override
    protected void assertUpdateAssertions(EventInfoResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
        });
    }

    @Override
    protected Class<EventInfoResponseDto> getResponseDtoClass() {
        return EventInfoResponseDto.class;
    }

    @Override
    protected UUID extractId(EventInfoResponseDto dto) {
        return dto.id();
    }
}
