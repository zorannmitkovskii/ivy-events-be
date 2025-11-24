package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.FeedbackBuilder;
import org.ivyinc.eventplanner.event.dto.FeedbackCreateDto;
import org.ivyinc.eventplanner.event.dto.FeedbackResponseDto;
import org.ivyinc.eventplanner.event.dto.FeedbackUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class FeedbackControllerIT extends BaseCrudControllerIT<FeedbackCreateDto, FeedbackUpdateDto, FeedbackResponseDto> {

    private final FeedbackBuilder.WeddingFeedback1 builder = new FeedbackBuilder.WeddingFeedback1();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected FeedbackCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected FeedbackUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(FeedbackResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
        });
    }

    @Override
    protected void assertUpdateAssertions(FeedbackResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
        });
    }

    @Override
    protected Class<FeedbackResponseDto> getResponseDtoClass() {
        return FeedbackResponseDto.class;
    }

    @Override
    protected UUID extractId(FeedbackResponseDto dto) {
        return dto.id();
    }
}
