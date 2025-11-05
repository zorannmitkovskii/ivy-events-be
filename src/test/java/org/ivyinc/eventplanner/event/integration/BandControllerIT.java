package org.ivyinc.eventplanner.event.integration;

import org.ivyinc.eventplanner.event.builder.BandDtoBuilder;
import org.ivyinc.eventplanner.event.dto.BandCreateDto;
import org.ivyinc.eventplanner.event.dto.BandUpdateDto;
import org.ivyinc.eventplanner.event.dto.BandResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.ivyinc.eventplanner.common.integration.BaseCrudControllerIT;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("BandController integration: generic CRUD flow")
class BandControllerIT extends BaseCrudControllerIT<
        BandCreateDto,
        BandUpdateDto,
        BandResponseDto
        > {

    private final BandDtoBuilder bandDtoBuilder = new BandDtoBuilder();

    @Override
    protected String getBasePath() {
        return "/v1/api/bands";
    }

    @Override
    protected BandCreateDto sampleCreateDto() {
        return bandDtoBuilder.sampleCreateDto();
    }

    @Override
    protected BandUpdateDto sampleUpdateDto() {
        return bandDtoBuilder.sampleUpdateDto();
    }

    @Override
    protected Class<BandResponseDto> getResponseDtoClass() {
        return BandResponseDto.class;
    }

    @Override
    protected UUID extractId(BandResponseDto dto) {
        return dto.id();
    }

    @Override
    protected void assertCreateAssertions(BandResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto.name()).isEqualTo("The Band");
            softly.assertThat(dto.description()).isEqualTo("Desc");
            softly.assertThat(dto.musicType()).isEqualTo("Live");
            softly.assertThat(dto.videoUrl()).isEqualTo("https://video");
            softly.assertThat(dto.providerId()).isEqualTo("prov-1");
            softly.assertThat(dto.songList()).isNotNull().hasSize(2).containsExactly("Song A", "Song B");
            softly.assertThat(dto.contact()).isNotNull();
            softly.assertThat(dto.contact().name()).isEqualTo("Alice");
            softly.assertThat(dto.contact().email()).isEqualTo("alice@mail.com");
            softly.assertThat(dto.contact().phone()).isEqualTo("123");
            softly.assertThat(dto.price()).isEqualTo(1000.0);
            softly.assertThat(dto.rating()).isEqualTo(4.5);
            softly.assertThat(dto.notes()).isEqualTo("notes");
        });
    }
    @Override
    protected void assertUpdateAssertions(BandResponseDto dto) {
        assertSoftly(softly -> {
            softly.assertThat(dto.id()).isNotNull();
            softly.assertThat(dto.name()).isEqualTo("The Band Updated");
            softly.assertThat(dto.description()).isEqualTo("Updated Description");
            softly.assertThat(dto.musicType()).isEqualTo("DJ");
            softly.assertThat(dto.videoUrl()).isEqualTo("https://updated-video");
            softly.assertThat(dto.providerId()).isEqualTo("prov-1");
            softly.assertThat(dto.songList())
                    .isNotNull()
                    .hasSize(3)
                    .containsExactly("Song X", "Song Y", "Song Z");
            softly.assertThat(dto.contact()).isNotNull();
            softly.assertThat(dto.contact().name()).isEqualTo("Alice Updated");
            softly.assertThat(dto.contact().email()).isEqualTo("alice.updated@mail.com");
            softly.assertThat(dto.contact().phone()).isEqualTo("456");
            softly.assertThat(dto.price()).isEqualTo(1200.0);
            softly.assertThat(dto.rating()).isEqualTo(5.0);
            softly.assertThat(dto.notes()).isEqualTo("updated notes");
        });
    }

}
