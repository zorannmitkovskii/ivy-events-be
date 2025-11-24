package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.InvitationBuilder;
import org.ivyinc.eventplanner.event.dto.InvitationCreateDto;
import org.ivyinc.eventplanner.event.dto.InvitationResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class InvitationControllerIT extends BaseCrudControllerIT<InvitationCreateDto, InvitationUpdateDto, InvitationResponseDto> {

    private final InvitationBuilder.Wedding builder = new InvitationBuilder.Wedding();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected InvitationCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected InvitationUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(InvitationResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
//            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
//            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
        });
    }

    @Override
    protected void assertUpdateAssertions(InvitationResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
//            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
//            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
        });
    }

    @Override
    protected Class<InvitationResponseDto> getResponseDtoClass() {
        return InvitationResponseDto.class;
    }

    @Override
    protected UUID extractId(InvitationResponseDto dto) {
        return dto.id();
    }
}
