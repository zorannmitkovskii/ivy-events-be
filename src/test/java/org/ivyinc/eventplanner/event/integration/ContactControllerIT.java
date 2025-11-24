package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.ContactBuilder;
import org.ivyinc.eventplanner.event.dto.ContactCreateDto;
import org.ivyinc.eventplanner.event.dto.ContactResponseDto;
import org.ivyinc.eventplanner.event.dto.ContactUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class ContactControllerIT extends BaseCrudControllerIT<ContactCreateDto, ContactUpdateDto, ContactResponseDto> {

    private final ContactBuilder.WeddingContact builder = new ContactBuilder.WeddingContact();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected ContactCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected ContactUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(ContactResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
        });
    }

    @Override
    protected void assertUpdateAssertions(ContactResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
        });
    }

    @Override
    protected Class<ContactResponseDto> getResponseDtoClass() {
        return ContactResponseDto.class;
    }

    @Override
    protected UUID extractId(ContactResponseDto dto) {
        return dto.id();
    }
}
