package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.InvitationTemplateBuilder;
import org.ivyinc.eventplanner.event.dto.InvitationTemplateCreateDto;
import org.ivyinc.eventplanner.event.dto.InvitationTemplateResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationTemplateUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class InvitationTemplateControllerIT extends BaseCrudControllerIT<InvitationTemplateCreateDto, InvitationTemplateUpdateDto, InvitationTemplateResponseDto> {

    private final InvitationTemplateBuilder builder = new InvitationTemplateBuilder();

    @Override
    protected String getBasePath() {
        return "/v1/api/invitation-templates";
    }

    @Override
    protected InvitationTemplateCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected InvitationTemplateUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(InvitationTemplateResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
//            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
//            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
        });
    }

    @Override
    protected void assertUpdateAssertions(InvitationTemplateResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
//            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
//            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
        });
    }

    @Override
    protected Class<InvitationTemplateResponseDto> getResponseDtoClass() {
        return InvitationTemplateResponseDto.class;
    }

    @Override
    protected UUID extractId(InvitationTemplateResponseDto dto) {
        return dto.id();
    }
}
