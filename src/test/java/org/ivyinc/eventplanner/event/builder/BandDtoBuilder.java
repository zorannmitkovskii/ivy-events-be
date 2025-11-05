package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.event.dto.*;

import java.util.List;
import java.util.UUID;

public class BandDtoBuilder {

    public BandCreateDto sampleCreateDto() {
        return new BandCreateDto(
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
    }

    public BandUpdateDto sampleUpdateDto() {
        return new BandUpdateDto(
                "The Band Updated",
                "Updated Description",
                "DJ",
                "https://updated-video",
                "prov-1",
                List.of("Song X", "Song Y", "Song Z"),
                new ContactUpdateDto("Alice Updated", "alice.updated@mail.com", "456"),
                1200.0,
                5.0,
                "updated notes",
                List.of()
        );
    }

     public BandResponseDto sampleResponse(UUID id) {
         return new BandResponseDto(
                 id,
                 "The Band",
                 "Desc",
                 "Live",
                 "https://video",
                 "prov-1",
                 List.of("Song A", "Song B"),
                 new ContactResponseDto(UUID.randomUUID(), "Alice", "alice@mail.com", "123"),
                 1000.0,
                 4.5,
                 "notes",
                 List.of()
         );
    }

    public BandResponseDto sampleUpdateResponse(UUID id) {
        return new BandResponseDto(
                id,
                "The Band Updated",
                "Updated Description",
                "DJ",
                "https://updated-video",
                "prov-1",
                List.of("Song X", "Song Y", "Song Z"),
                new ContactResponseDto(null, "Alice Updated3", "alice.updated@mail.com", "456"),
                1200.0,
                5.0,
                "updated notes",
                List.of()
        );
    }
}
