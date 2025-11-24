package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.FormFieldAnswerBuilder;
import org.ivyinc.eventplanner.event.dto.FormFieldAnswerCreateDto;
import org.ivyinc.eventplanner.event.dto.FormFieldAnswerResponseDto;
import org.ivyinc.eventplanner.event.dto.FormFieldAnswerUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class FormFieldAnswerControllerIT extends BaseCrudControllerIT<FormFieldAnswerCreateDto, FormFieldAnswerUpdateDto, FormFieldAnswerResponseDto> {

    private final FormFieldAnswerBuilder.WeddingFormFieldAnswer builder = new FormFieldAnswerBuilder.WeddingFormFieldAnswer();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected FormFieldAnswerCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected FormFieldAnswerUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(FormFieldAnswerResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
        });
    }

    @Override
    protected void assertUpdateAssertions(FormFieldAnswerResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
        });
    }

    @Override
    protected Class<FormFieldAnswerResponseDto> getResponseDtoClass() {
        return FormFieldAnswerResponseDto.class;
    }

    @Override
    protected UUID extractId(FormFieldAnswerResponseDto dto) {
        return dto.id();
    }
}
