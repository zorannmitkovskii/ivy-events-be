package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.FieldOptionBuilder;
import org.ivyinc.eventplanner.event.dto.FieldOptionCreateDto;
import org.ivyinc.eventplanner.event.dto.FieldOptionResponseDto;
import org.ivyinc.eventplanner.event.dto.FieldOptionUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class FieldOptionControllerIT extends BaseCrudControllerIT<FieldOptionCreateDto, FieldOptionUpdateDto, FieldOptionResponseDto> {

    private final FieldOptionBuilder builder = new FieldOptionBuilder();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected FieldOptionCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected FieldOptionUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(FieldOptionResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
        });
    }

    @Override
    protected void assertUpdateAssertions(FieldOptionResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
        });
    }

    @Override
    protected Class<FieldOptionResponseDto> getResponseDtoClass() {
        return FieldOptionResponseDto.class;
    }

    @Override
    protected UUID extractId(FieldOptionResponseDto dto) {
        return dto.id();
    }
}
