package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.BudgetBuilder;
import org.ivyinc.eventplanner.event.builder.EventCategoryBuilder;
import org.ivyinc.eventplanner.event.dto.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class BudgetControllerIT extends BaseCrudControllerIT<BudgetCreateDto, BudgetUpdateDto, BudgetResponseDto> {

    private final BudgetBuilder.WeddingBudget builder = new BudgetBuilder.WeddingBudget();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected BudgetCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected BudgetUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(BudgetResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
        });
    }

    @Override
    protected void assertUpdateAssertions(BudgetResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
        });
    }

    @Override
    protected Class<BudgetResponseDto> getResponseDtoClass() {
        return BudgetResponseDto.class;
    }

    @Override
    protected UUID extractId(BudgetResponseDto dto) {
        return dto.id();
    }
}
