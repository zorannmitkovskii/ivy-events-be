package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.FormSubmissionBuilder;
import org.ivyinc.eventplanner.event.dto.FormSubmissionCreateDto;
import org.ivyinc.eventplanner.event.dto.FormSubmissionResponseDto;
import org.ivyinc.eventplanner.event.dto.FormSubmissionUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class FormSubmissionControllerIT extends BaseCrudControllerIT<FormSubmissionCreateDto, FormSubmissionUpdateDto, FormSubmissionResponseDto> {

    private final FormSubmissionBuilder.WeddingFormSubmission builder = new FormSubmissionBuilder.WeddingFormSubmission();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected FormSubmissionCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected FormSubmissionUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(FormSubmissionResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
        });
    }

    @Override
    protected void assertUpdateAssertions(FormSubmissionResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
        });
    }

    @Override
    protected Class<FormSubmissionResponseDto> getResponseDtoClass() {
        return FormSubmissionResponseDto.class;
    }

    @Override
    protected UUID extractId(FormSubmissionResponseDto dto) {
        return dto.id();
    }
}
