package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.VendorBuilder;
import org.ivyinc.eventplanner.event.dto.VendorCreateDto;
import org.ivyinc.eventplanner.event.dto.VendorResponseDto;
import org.ivyinc.eventplanner.event.dto.VendorUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class VendorControllerIT extends BaseCrudControllerIT<VendorCreateDto, VendorUpdateDto, VendorResponseDto> {

    private final VendorBuilder.WeddingVendor builder = new VendorBuilder.WeddingVendor();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected VendorCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected VendorUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(VendorResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
//            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
        });
    }

    @Override
    protected void assertUpdateAssertions(VendorResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
//            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
        });
    }

    @Override
    protected Class<VendorResponseDto> getResponseDtoClass() {
        return VendorResponseDto.class;
    }

    @Override
    protected UUID extractId(VendorResponseDto dto) {
        return dto.id();
    }
}
