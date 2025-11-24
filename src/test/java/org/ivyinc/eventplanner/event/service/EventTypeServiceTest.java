package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.event.builder.EventTypeBuilder;
import org.ivyinc.eventplanner.event.dto.EventTypeCreateDto;
import org.ivyinc.eventplanner.event.dto.EventTypeResponseDto;
import org.ivyinc.eventplanner.event.dto.EventTypeUpdateDto;
import org.ivyinc.eventplanner.event.mapper.EventTypeMapper;
import org.ivyinc.eventplanner.event.model.EventType;
import org.ivyinc.eventplanner.event.repository.EventTypeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventTypeServiceTest {

    @Mock
    private EventTypeRepository repository;

    @Mock
    private EventTypeMapper mapper;

    @InjectMocks
    private EventTypeService service;

    private final EventTypeBuilder builder = new EventTypeBuilder();

    @Test
    @DisplayName("create should save and return mapped response")
    void create_shouldSaveAndReturnResponse() {
        EventTypeCreateDto create = builder.sampleCreateDto();
        EventType entity = builder.sampleEntity();
        EventTypeResponseDto expected = builder.sampleCreateResponse(UUID.randomUUID());

        when(mapper.toEntity(create)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toResponse(entity)).thenReturn(expected);

        EventTypeResponseDto result = service.create(create);
        assertThat(result).isEqualTo(expected);

        verify(mapper).toEntity(create);
        verify(repository).save(entity);
        verify(mapper).toResponse(entity);
    }

    @Test
    @DisplayName("update should find, update, save and return response")
    void update_shouldUpdateAndReturnResponse() {
        String id = UUID.randomUUID().toString();
        EventType entity = builder.sampleEntity();
        EventTypeUpdateDto update = builder.sampleUpdateDto();
        EventTypeResponseDto expected = builder.sampleUpdateResponse(UUID.fromString(id));

        when(repository.findById(UUID.fromString(id))).thenReturn(Optional.of(entity));
        doNothing().when(mapper).updateEntity(entity, update);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toResponse(entity)).thenReturn(expected);

        EventTypeResponseDto result = service.update(id, update);
        assertThat(result).isEqualTo(expected);

        verify(repository).findById(UUID.fromString(id));
        verify(mapper).updateEntity(entity, update);
        verify(repository).save(entity);
        verify(mapper).toResponse(entity);
    }

    @Test
    @DisplayName("findAll should return mapped responses")
    void findAll_shouldReturnMappedResponses() {
        List<EventType> entities = List.of(builder.sampleEntity());
        List<EventTypeResponseDto> expected = List.of(builder.sampleCreateResponse(UUID.randomUUID()));

        when(repository.findAll()).thenReturn(entities);
        when(mapper.toResponses(entities)).thenReturn(expected);

        List<EventTypeResponseDto> result = service.findAll();
        assertThat(result).isEqualTo(expected);

        verify(repository).findAll();
        verify(mapper).toResponses(entities);
    }

    @Test
    @DisplayName("delete should call repository.deleteById")
    void delete_shouldCallRepository() {
        String id = UUID.randomUUID().toString();
        doNothing().when(repository).deleteById(UUID.fromString(id));
        service.delete(id);
        verify(repository).deleteById(UUID.fromString(id));
    }
}
