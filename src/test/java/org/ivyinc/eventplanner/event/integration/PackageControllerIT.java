package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.PackageBuilder;
import org.ivyinc.eventplanner.event.dto.PackageCreateDto;
import org.ivyinc.eventplanner.event.dto.PackageResponseDto;
import org.ivyinc.eventplanner.event.dto.PackageUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class PackageControllerIT extends BaseCrudControllerIT<PackageCreateDto, PackageUpdateDto, PackageResponseDto> {

    private final PackageBuilder.WeddingPackage builder = new PackageBuilder.WeddingPackage();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected PackageCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected PackageUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(PackageResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
        });
    }

    @Override
    protected void assertUpdateAssertions(PackageResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
        });
    }

    @Override
    protected Class<PackageResponseDto> getResponseDtoClass() {
        return PackageResponseDto.class;
    }

    @Override
    protected UUID extractId(PackageResponseDto dto) {
        return dto.id();
    }
}
