package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;
import org.ivyinc.eventplanner.event.builder.EventTypeBuilder;
import org.ivyinc.eventplanner.event.dto.EventTypeCreateDto;
import org.ivyinc.eventplanner.event.dto.EventTypeResponseDto;
import org.ivyinc.eventplanner.event.dto.EventTypeUpdateDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration")
@ActiveProfiles("test")
class EventTypeControllerIT extends BaseCrudControllerIT<EventTypeCreateDto, EventTypeUpdateDto, EventTypeResponseDto> {

    private final EventTypeBuilder builder = new EventTypeBuilder();
    private final org.ivyinc.eventplanner.event.builder.EventCategoryBuilder.Corporate categoryBuilder = new org.ivyinc.eventplanner.event.builder.EventCategoryBuilder.Corporate();
    private UUID categoryId;

    @BeforeEach
    void setupCategory() throws Exception {
        var mvcRes = mockMvc.perform(post("/v1/api/event-categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(categoryBuilder.sampleCreateDto())))
                .andReturn();
        JsonNode node = objectMapper.readTree(mvcRes.getResponse().getContentAsString());
        categoryId = UUID.fromString(node.get("id").asText());
    }

    @Override
    protected String getBasePath() {
        return "/v1/api/event-types";
    }

    @Override
    protected EventTypeCreateDto sampleCreateDto() {
        var c = builder.sampleCreateDto();
        return new EventTypeCreateDto(categoryId, c.name(), c.description());
    }

    @Override
    protected EventTypeUpdateDto sampleUpdateDto() {
        var u = builder.sampleUpdateDto();
        return new EventTypeUpdateDto(categoryId, u.name(), u.description());
    }

    @Override
    protected void assertCreateAssertions(EventTypeResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.id()).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleCreateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleCreateDto().description());
            softly.assertThat(dto.eventCategory()).isNotNull();
        });
    }

    @Override
    protected void assertUpdateAssertions(EventTypeResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto).isNotNull();
            softly.assertThat(dto.name()).isEqualTo(builder.sampleUpdateDto().name());
            softly.assertThat(dto.description()).isEqualTo(builder.sampleUpdateDto().description());
            softly.assertThat(dto.eventCategory()).isNotNull();
        });
    }

    @Override
    protected Class<EventTypeResponseDto> getResponseDtoClass() {
        return EventTypeResponseDto.class;
    }

    @Override
    protected UUID extractId(EventTypeResponseDto dto) {
        return dto.id();
    }
}
