package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.RegistrationFormBuilder;
import org.ivyinc.eventplanner.event.dto.FormCreateDto;
import org.ivyinc.eventplanner.event.dto.FormResponseDto;
import org.ivyinc.eventplanner.event.dto.FormUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration")
@ActiveProfiles("test")
class FormControllerIT extends BaseCrudControllerIT<FormCreateDto, FormUpdateDto, FormResponseDto> {

    private final RegistrationFormBuilder builder = new RegistrationFormBuilder();

    @Override
    protected String getBasePath() {
        return "/v1/api/forms";
    }

    @Override
    protected FormCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected FormUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(FormResponseDto dto) {
        assertSoftly(softly ->{
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
            softly.assertThat(dto.version()).isEqualTo(builder.sampleCreateDto().version());
        });
    }

    @Override
    protected void assertUpdateAssertions(FormResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
            softly.assertThat(dto.version()).isEqualTo(builder.sampleUpdateDto().version());
        });
    }

    @Override
    protected Class<FormResponseDto> getResponseDtoClass() {
        return FormResponseDto.class;
    }

    @Override
    protected UUID extractId(FormResponseDto dto) {
        return dto.id();
    }
}
