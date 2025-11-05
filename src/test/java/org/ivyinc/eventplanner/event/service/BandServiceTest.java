package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.mapper.BandMapper;
import org.ivyinc.eventplanner.event.model.Band;
import org.ivyinc.eventplanner.event.model.Contact;
import org.ivyinc.eventplanner.event.repository.BandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BandServiceTest extends org.ivyinc.eventplanner.common.service.BaseServiceTest {

    @Mock
    private BandRepository repository;

    @Mock
    private BandMapper mapper;

    @InjectMocks
    private BandService service;

    @BeforeEach
    void setUp() {
        service = new BandService(repository, mapper);
    }

    private BandCreateDto sampleCreateDto() {
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

    private BandUpdateDto sampleUpdateDto() {
        return new BandUpdateDto(
                "The Band Updated",
                "Desc2",
                "DJ",
                "https://video2",
                "prov-2",
                List.of("Song C"),
                new ContactUpdateDto("Bob", "bob@mail.com", "456"),
                2000.0,
                4.8,
                "notes2",
                List.of()
        );
    }

    private Band sampleEntity(UUID id) {
        Band band = Band.builder()
                .name("The Band")
                .description("Desc")
                .musicType("Live")
                .videoUrl("https://video")
                .providerId("prov-1")
                .songList(List.of("Song A", "Song B"))
                .contact(new Contact("Alice", "alice@mail.com", "123"))
                .price(1000.0)
                .rating(4.5)
                .notes("notes")
                .build();
        band.setId(id);
        return band;
    }

    private BandResponseDto sampleResponse(UUID id) {
        return new BandResponseDto(
                id,
                "The Band",
                "Desc",
                "Live",
                "https://video",
                "prov-1",
                List.of("Song A", "Song B"),
                new ContactResponseDto(null, "Alice", "alice@mail.com", "123"),
                1000.0,
                4.5,
                "notes",
                List.of()
        );
    }

    @Test
    @DisplayName("create: should convert DTO to entity, save, and return response")
    void testCreate() {
        BandCreateDto dto = sampleCreateDto();
        Band entity = sampleEntity(null);
        Band saved = sampleEntity(UUID.randomUUID());
        BandResponseDto response = sampleResponse(UUID.randomUUID());

        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(saved);
        when(mapper.toResponse(saved)).thenReturn(response);

        BandResponseDto result = service.create(dto);

        assertNotNull(result);
        assertEquals(response.id(), result.id());
        verify(mapper).toEntity(dto);
        verify(repository).save(entity);
        verify(mapper).toResponse(saved);
    }

    @Test
    @DisplayName("update: when entity exists, should update via mapper and save")
    void testUpdateSuccess() {
        UUID id = UUID.randomUUID();
        Band existing = sampleEntity(id);
        BandUpdateDto dto = sampleUpdateDto();
        Band saved = sampleEntity(id);
        BandResponseDto response = sampleResponse(id);

        when(repository.findById(id)).thenReturn(Optional.of(existing));
        when(repository.save(existing)).thenReturn(saved);
        when(mapper.toResponse(saved)).thenReturn(response);

        BandResponseDto result = service.update(id.toString(), dto);

        assertNotNull(result);
        assertEquals(id, result.id());
        verify(repository).findById(id);
        verify(mapper).updateEntity(existing, dto);
        verify(repository).save(existing);
        verify(mapper).toResponse(saved);
    }

    @Test
    @DisplayName("update: when entity missing, should throw RuntimeException")
    void testUpdateNotFound() {
        UUID id = UUID.randomUUID();
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.update(id.toString(), sampleUpdateDto()));
        verify(repository).findById(id);
        verify(repository, never()).save(any());
    }

    @Test
    @DisplayName("delete: should delegate to repository.deleteById")
    void testDelete() {
        UUID id = UUID.randomUUID();
        service.delete(id.toString());
        ArgumentCaptor<UUID> captor = ArgumentCaptor.forClass(UUID.class);
        verify(repository).deleteById(captor.capture());
        assertEquals(id, captor.getValue());
    }

    @Test
    @DisplayName("findById: when present, should map to response")
    void testFindByIdPresent() {
        UUID id = UUID.randomUUID();
        Band entity = sampleEntity(id);
        BandResponseDto response = sampleResponse(id);

        when(repository.findById(id)).thenReturn(Optional.of(entity));
        when(mapper.toResponse(entity)).thenReturn(response);

        BandResponseDto result = service.findById(id.toString());
        assertNotNull(result);
        assertEquals(id, result.id());
        verify(repository).findById(id);
        verify(mapper).toResponse(entity);
    }

    @Test
    @DisplayName("findById: when absent, should return null")
    void testFindByIdAbsent() {
        UUID id = UUID.randomUUID();
        when(repository.findById(id)).thenReturn(Optional.empty());

        BandResponseDto result = service.findById(id.toString());
        assertNull(result);
        verify(repository).findById(id);
        // mapper.toResponse(null) implicitly returns null; no need to verify
    }

    @Test
    @DisplayName("findAll: should return mapped list")
    void testFindAll() {
        Band e1 = sampleEntity(UUID.randomUUID());
        Band e2 = sampleEntity(UUID.randomUUID());
        List<Band> entities = Arrays.asList(e1, e2);
        BandResponseDto r1 = sampleResponse(UUID.randomUUID());
        BandResponseDto r2 = sampleResponse(UUID.randomUUID());
        List<BandResponseDto> responses = Arrays.asList(r1, r2);

        when(repository.findAll()).thenReturn(entities);
        when(mapper.toResponses(entities)).thenReturn(responses);

        List<BandResponseDto> result = service.findAll();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(repository).findAll();
        verify(mapper).toResponses(entities);
    }
}
