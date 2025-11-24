package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.ScheduleBuilder;
import org.ivyinc.eventplanner.event.dto.ScheduleCreateDto;
import org.ivyinc.eventplanner.event.dto.ScheduleResponseDto;
import org.ivyinc.eventplanner.event.dto.ScheduleUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class ScheduleControllerIT extends BaseCrudControllerIT<ScheduleCreateDto, ScheduleUpdateDto, ScheduleResponseDto> {

    private final ScheduleBuilder.WeddingSchedule builder = new ScheduleBuilder.WeddingSchedule();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected ScheduleCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected ScheduleUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(ScheduleResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
//            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
        });
    }

    @Override
    protected void assertUpdateAssertions(ScheduleResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
//            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
        });
    }

    @Override
    protected Class<ScheduleResponseDto> getResponseDtoClass() {
        return ScheduleResponseDto.class;
    }

    @Override
    protected UUID extractId(ScheduleResponseDto dto) {
        return dto.id();
    }
}
