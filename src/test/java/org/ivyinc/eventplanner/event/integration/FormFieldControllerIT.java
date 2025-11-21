package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.FormFieldBuilder;
import org.ivyinc.eventplanner.event.dto.FormFieldCreateDto;
import org.ivyinc.eventplanner.event.dto.FormFieldResponseDto;
import org.ivyinc.eventplanner.event.dto.FormFieldUpdateDto;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration")
@ActiveProfiles("test")
class FormFieldControllerIT extends BaseCrudControllerIT<FormFieldCreateDto, FormFieldUpdateDto, FormFieldResponseDto> {

    private final FormFieldBuilder builder = new FormFieldBuilder();

    @Override
    protected String getBasePath() {
        return "/v1/api/form-fields";
    }

    @Override
    protected FormFieldCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected FormFieldUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(FormFieldResponseDto dto) {
        assertThat(dto).isNotNull();
        assertThat(dto.id()).isNotNull();
        assertThat(dto.label()).isEqualTo(builder.sampleCreateDto().label());
        assertThat(dto.type()).isEqualTo(builder.sampleCreateDto().type());
        assertThat(dto.orderIndex()).isEqualTo(builder.sampleCreateDto().orderIndex());
        assertThat(dto.required()).isEqualTo(builder.sampleCreateDto().required());
    }

    @Override
    protected void assertUpdateAssertions(FormFieldResponseDto dto) {
        assertThat(dto).isNotNull();
        assertThat(dto.label()).isEqualTo(builder.sampleUpdateDto().label());
        assertThat(dto.type()).isEqualTo(builder.sampleUpdateDto().type());
        assertThat(dto.orderIndex()).isEqualTo(builder.sampleUpdateDto().orderIndex());
        assertThat(dto.required()).isEqualTo(Boolean.TRUE.equals(builder.sampleUpdateDto().required()));
    }

    @Override
    protected Class<FormFieldResponseDto> getResponseDtoClass() {
        return FormFieldResponseDto.class;
    }

    @Override
    protected UUID extractId(FormFieldResponseDto dto) {
        return dto.id();
    }
}
