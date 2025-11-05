package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.event.model.Band;
import org.ivyinc.eventplanner.event.model.Contact;
import org.ivyinc.eventplanner.event.model.Event;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class BandRepositoryTest {

    @Autowired
    private BandRepository repository;

    private Band newBand() {
        return Band.builder()
                .name("The Band")
                .description("Desc")
                .musicType("Live")
                .videoUrl("https://video")
                .providerId("prov-1")
                .songList(new java.util.ArrayList<>(java.util.Arrays.asList("Song A", "Song B")))
                .contact(new Contact("Alice", "alice@mail.com", "123"))
                .price(1000.0)
                .rating(4.5)
                .notes("notes")
                .build();
    }

    @Test
    @DisplayName("save and findById should persist and retrieve Band with all fields")
    void saveAndFindById() {
        Band saved = repository.save(newBand());
        assertThat(saved.getId()).isNotNull();

        Optional<Band> foundOpt = repository.findById(saved.getId());
        assertThat(foundOpt).isPresent();
        Band found = foundOpt.get();

        assertThat(found.getName()).isEqualTo("The Band");
        assertThat(found.getDescription()).isEqualTo("Desc");
        assertThat(found.getMusicType()).isEqualTo("Live");
        assertThat(found.getVideoUrl()).isEqualTo("https://video");
        assertThat(found.getProviderId()).isEqualTo("prov-1");
        assertThat(found.getSongList()).containsExactly("Song A", "Song B");
        assertThat(found.getContact()).isNotNull();
        assertThat(found.getContact().getName()).isEqualTo("Alice");
        assertThat(found.getContact().getEmail()).isEqualTo("alice@mail.com");
        assertThat(found.getContact().getPhone()).isEqualTo("123");
        assertThat(found.getPrice()).isEqualTo(1000.0);
        assertThat(found.getRating()).isEqualTo(4.5);
        assertThat(found.getNotes()).isEqualTo("notes");
    }

    @Test
    @DisplayName("update should modify persisted fields including song list and contact details")
    void updateEntity() {
        Band saved = repository.save(newBand());

        saved.setName("The Band Updated");
        saved.setDescription("Updated Description");
        saved.setMusicType("DJ");
        saved.setVideoUrl("https://updated-video");
        saved.setProviderId("prov-2");
        saved.setSongList(new java.util.ArrayList<>(java.util.Arrays.asList("Song X", "Song Y", "Song Z")));
        saved.setContact(new Contact("Alice Updated", "alice.updated@mail.com", "456"));
        saved.setPrice(1200.0);
        saved.setRating(5.0);
        saved.setNotes("updated notes");

        Band updated = repository.save(saved);

        Band found = repository.findById(updated.getId()).orElseThrow();
        assertThat(found.getName()).isEqualTo("The Band Updated");
        assertThat(found.getDescription()).isEqualTo("Updated Description");
        assertThat(found.getMusicType()).isEqualTo("DJ");
        assertThat(found.getVideoUrl()).isEqualTo("https://updated-video");
        assertThat(found.getProviderId()).isEqualTo("prov-2");
        assertThat(found.getSongList()).containsExactly("Song X", "Song Y", "Song Z");
        assertThat(found.getContact()).isNotNull();
        assertThat(found.getContact().getName()).isEqualTo("Alice Updated");
        assertThat(found.getContact().getEmail()).isEqualTo("alice.updated@mail.com");
        assertThat(found.getContact().getPhone()).isEqualTo("456");
        assertThat(found.getPrice()).isEqualTo(1200.0);
        assertThat(found.getRating()).isEqualTo(5.0);
        assertThat(found.getNotes()).isEqualTo("updated notes");
    }

    @Test
    @DisplayName("delete should remove entity by id")
    void deleteById() {
        Band saved = repository.save(newBand());
        UUID id = saved.getId();

        repository.deleteById(id);

        assertThat(repository.findById(id)).isEmpty();
    }
}
