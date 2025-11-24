package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.InvitationSectionBuilder;
import org.ivyinc.eventplanner.event.dto.InvitationSectionCreateDto;
import org.ivyinc.eventplanner.event.dto.InvitationSectionResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationSectionUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class InvitationSectionControllerIT extends BaseCrudControllerIT<InvitationSectionCreateDto, InvitationSectionUpdateDto, InvitationSectionResponseDto> {

    private final InvitationSectionBuilder builder = new InvitationSectionBuilder();

    @Override
    protected String getBasePath() {
        return "/v1/api/invitation-sections";
    }

    @Override
    protected InvitationSectionCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected InvitationSectionUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(InvitationSectionResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
//            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
//            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
        });
    }

    @Override
    protected void assertUpdateAssertions(InvitationSectionResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
//            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
//            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
        });
    }

    @Override
    protected Class<InvitationSectionResponseDto> getResponseDtoClass() {
        return InvitationSectionResponseDto.class;
    }

    @Override
    protected UUID extractId(InvitationSectionResponseDto dto) {
        return dto.id();
    }
}
