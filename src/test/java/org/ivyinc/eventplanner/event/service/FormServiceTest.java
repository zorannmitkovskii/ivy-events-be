package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.event.builder.RegistrationFormBuilder;
import org.ivyinc.eventplanner.event.dto.FormCreateDto;
import org.ivyinc.eventplanner.event.dto.FormResponseDto;
import org.ivyinc.eventplanner.event.dto.FormUpdateDto;
import org.ivyinc.eventplanner.event.mapper.FormMapper;
import org.ivyinc.eventplanner.event.model.Form;
import org.ivyinc.eventplanner.event.repository.FormRepository;
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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FormServiceTest {

    @Mock
    private FormRepository repository;

    @Mock
    private FormMapper mapper;

    @InjectMocks
    private FormService service;

    private final RegistrationFormBuilder builder = new RegistrationFormBuilder();

    @Test
    @DisplayName("create should map dto, save entity, and return response")
    void create_shouldSaveAndReturnResponse() {
        FormCreateDto createDto = builder.sampleCreateDto();
        Form entity = builder.sampleEntity();
        FormResponseDto expected = builder.sampleCreateResponse(UUID.randomUUID());

        when(mapper.toEntity(createDto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toResponse(entity)).thenReturn(expected);

        FormResponseDto result = service.create(createDto);
        assertThat(result).isEqualTo(expected);

        verify(mapper).toEntity(createDto);
        verify(repository).save(entity);
        verify(mapper).toResponse(entity);
    }

    @Test
    @DisplayName("update should find entity, apply update, save and return response")
    void update_shouldUpdateAndReturnResponse() {
        String id = UUID.randomUUID().toString();
        Form entity = builder.sampleEntity();
        FormUpdateDto updateDto = builder.sampleUpdateDto();
        FormResponseDto expected = builder.sampleUpdateResponse(UUID.fromString(id));

        when(repository.findById(UUID.fromString(id))).thenReturn(Optional.of(entity));
        // updateEntity is void; just verify it's invoked
        doNothing().when(mapper).updateEntity(entity, updateDto);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toResponse(entity)).thenReturn(expected);

        FormResponseDto result = service.update(id, updateDto);
        assertThat(result).isEqualTo(expected);

        verify(repository).findById(UUID.fromString(id));
        verify(mapper).updateEntity(entity, updateDto);
        verify(repository).save(entity);
        verify(mapper).toResponse(entity);
    }

    @Test
    @DisplayName("findById should map repository result to response")
    void findById_shouldReturnResponse() {
        String id = UUID.randomUUID().toString();
        Form entity = builder.sampleEntity();
        FormResponseDto expected = builder.sampleCreateResponse(UUID.fromString(id));

        when(repository.findById(UUID.fromString(id))).thenReturn(Optional.of(entity));
        when(mapper.toResponse(entity)).thenReturn(expected);

        FormResponseDto result = service.findById(id);
        assertThat(result).isEqualTo(expected);

        verify(repository).findById(UUID.fromString(id));
        verify(mapper).toResponse(entity);
    }

    @Test
    @DisplayName("findAll should map repository results to responses")
    void findAll_shouldReturnMappedResponses() {
        Form e1 = builder.sampleEntity();
        Form e2 = builder.sampleEntity();
        List<Form> entities = List.of(e1, e2);
        List<FormResponseDto> expected = List.of(
                builder.sampleCreateResponse(UUID.randomUUID()),
                builder.sampleCreateResponse(UUID.randomUUID())
        );

        when(repository.findAll()).thenReturn(entities);
        when(mapper.toResponses(entities)).thenReturn(expected);

        List<FormResponseDto> result = service.findAll();
        assertThat(result).isEqualTo(expected);

        verify(repository).findAll();
        verify(mapper).toResponses(entities);
    }

    @Test
    @DisplayName("delete should call repository.deleteById")
    void delete_shouldInvokeRepository() {
        String id = UUID.randomUUID().toString();
        doNothing().when(repository).deleteById(UUID.fromString(id));

        service.delete(id);

        verify(repository).deleteById(UUID.fromString(id));
    }
}
