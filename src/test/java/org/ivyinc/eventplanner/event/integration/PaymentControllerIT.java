package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.PaymentBuilder;
import org.ivyinc.eventplanner.event.dto.PaymentCreateDto;
import org.ivyinc.eventplanner.event.dto.PaymentResponseDto;
import org.ivyinc.eventplanner.event.dto.PaymentUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class PaymentControllerIT extends BaseCrudControllerIT<PaymentCreateDto, PaymentUpdateDto, PaymentResponseDto> {

    private final PaymentBuilder builder = new PaymentBuilder();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected PaymentCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected PaymentUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(PaymentResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
//            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
//            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
        });
    }

    @Override
    protected void assertUpdateAssertions(PaymentResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
//            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
//            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
        });
    }

    @Override
    protected Class<PaymentResponseDto> getResponseDtoClass() {
        return PaymentResponseDto.class;
    }

    @Override
    protected UUID extractId(PaymentResponseDto dto) {
        return dto.id();
    }
}
