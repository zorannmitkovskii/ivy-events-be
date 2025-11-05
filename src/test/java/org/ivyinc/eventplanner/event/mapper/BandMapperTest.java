package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.model.Band;
import org.ivyinc.eventplanner.event.model.Contact;
import org.ivyinc.eventplanner.event.model.Event;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest
@ActiveProfiles("test")
class BandMapperTest {

    @Autowired
    private BandMapper mapper;

    @Test
    @DisplayName("toEntity should map nested contact object")
    void toEntity_shouldMapNestedContact() {
        BandCreateDto create = new BandCreateDto(
                "The Band",
                "Desc",
                "Live",
                "https://video",
                "prov-1",
                List.of("Song A", "Song B"),
                new ContactCreateDto("Alice", "alice@mail.com", "123"),
                1000.0,
                4.5,
                "notes",
                List.of()
        );

        Band entity = mapper.toEntity(create);
        assertSoftly(softly -> {
            softly.assertThat(entity).isNotNull();
            softly.assertThat(entity.getName()).isEqualTo("The Band");
            softly.assertThat(entity.getDescription()).isEqualTo("Desc");
            softly.assertThat(entity.getMusicType()).isEqualTo("Live");
            softly.assertThat(entity.getVideoUrl()).isEqualTo("https://video");
            softly.assertThat(entity.getContact()).isNotNull();
            softly.assertThat(entity.getContact().getName()).isEqualTo("Alice");
            softly.assertThat(entity.getContact().getEmail()).isEqualTo("alice@mail.com");
            softly.assertThat(entity.getContact().getPhone()).isEqualTo("123");
            softly.assertThat(entity.getRating()).isEqualTo(4.5);
            softly.assertThat(entity.getNotes()).isEqualTo("notes");
        });
    }

    @Test
    @DisplayName("toResponse should map entity contact into ContactResponseDto")
    void toResponse_shouldBuildNestedContact() {
        Band entity = Band.builder()
                .name("The Band")
                .description("Desc")
                .musicType("Live")
                .videoUrl("https://video")
                .contact(new Contact("Alice", "alice@mail.com", "123"))
                .rating(4.5)
                .notes("notes")
                .build();
        entity.setId(UUID.randomUUID());
        // also set event id to validate string conversion

        BandResponseDto response = mapper.toResponse(entity);
        assertSoftly(softly -> {
            softly.assertThat(response).isNotNull();
            softly.assertThat(response.id()).isEqualTo(entity.getId());
            softly.assertThat(response.name()).isEqualTo("The Band");
            softly.assertThat(response.description()).isEqualTo("Desc");
            softly.assertThat(response.musicType()).isEqualTo("Live");
            softly.assertThat(response.videoUrl()).isEqualTo("https://video");
            softly.assertThat(response.providerId()).isEqualTo("prov-1");
            softly.assertThat(response.songList()).containsExactly("Song A", "Song B");
            softly.assertThat(response.contact()).isNotNull();
            softly.assertThat(response.contact().name()).isEqualTo("Alice");
            softly.assertThat(response.contact().email()).isEqualTo("alice@mail.com");
            softly.assertThat(response.contact().phone()).isEqualTo("123");
            softly.assertThat(response.price()).isEqualTo(1000.0);
            softly.assertThat(response.rating()).isEqualTo(4.5);
            softly.assertThat(response.notes()).isEqualTo("notes");
        });
    }

    @Test
    @DisplayName("updateEntity should update contact via AfterMapping and ignore nulls")
    void updateEntity_shouldUpdateContactAndIgnoreNulls() {
        Band entity = Band.builder()
                .name("The Band")
                .description("Desc")
                .musicType("Live")
                .videoUrl("https://video")
                .contact(new Contact("Alice", "alice@mail.com", "123"))
                .rating(4.5)
                .notes("notes")
                .build();

        // Only update some top-level fields and nested contact name; keep others null to test IGNORE
        BandUpdateDto update = new BandUpdateDto(
                "The Band Updated",
                null,
                null,
                null,
                null,
                null,
                new ContactUpdateDto("Alice Updated", null, null),
                1200.0,
                null,
                null,
                List.of()
        );

        mapper.updateEntity(entity, update); // triggers @AfterMapping for contact

        assertSoftly(softly -> {
            softly.assertThat(entity.getName()).isEqualTo("The Band Updated");
            softly.assertThat(entity.getDescription()).isEqualTo("Desc");
            softly.assertThat(entity.getMusicType()).isEqualTo("Live");
            softly.assertThat(entity.getVideoUrl()).isEqualTo("https://video");
            softly.assertThat(entity.getContact()).isNotNull();
            softly.assertThat(entity.getContact().getName()).isEqualTo("Alice Updated");
            softly.assertThat(entity.getContact().getEmail()).isEqualTo("alice@mail.com");
            softly.assertThat(entity.getContact().getPhone()).isEqualTo("123");
            softly.assertThat(entity.getRating()).isEqualTo(4.5);
            softly.assertThat(entity.getNotes()).isEqualTo("notes");
        });
    }
}
