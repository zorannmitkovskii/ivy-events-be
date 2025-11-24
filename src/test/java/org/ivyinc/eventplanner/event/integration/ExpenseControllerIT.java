package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.ExpenseBuilder;
import org.ivyinc.eventplanner.event.dto.ExpenseCreateDto;
import org.ivyinc.eventplanner.event.dto.ExpenseResponseDto;
import org.ivyinc.eventplanner.event.dto.ExpenseUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class ExpenseControllerIT extends BaseCrudControllerIT<ExpenseCreateDto, ExpenseUpdateDto, ExpenseResponseDto> {

    private final ExpenseBuilder.WeddingExpense builder = new ExpenseBuilder.WeddingExpense();

    @Override
    protected String getBasePath() {
        return "/v1/api/event-categories";
    }

    @Override
    protected ExpenseCreateDto sampleCreateDto() {
        return builder.sampleCreateDto();
    }

    @Override
    protected ExpenseUpdateDto sampleUpdateDto() {
        return builder.sampleUpdateDto();
    }

    @Override
    protected void assertCreateAssertions(ExpenseResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
        });
    }

    @Override
    protected void assertUpdateAssertions(ExpenseResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
        });
    }

    @Override
    protected Class<ExpenseResponseDto> getResponseDtoClass() {
        return ExpenseResponseDto.class;
    }

    @Override
    protected UUID extractId(ExpenseResponseDto dto) {
        return dto.id();
    }
}
