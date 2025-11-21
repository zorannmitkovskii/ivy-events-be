package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.model.Form;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public abstract class FormBuilder implements DtoBuilder<
        Form,
        FormCreateDto,
        FormUpdateDto,
        FormResponseDto
        > {

    @Override
    public abstract Form sampleEntity();

    @Override
    public abstract FormCreateDto sampleCreateDto();

    @Override
    public abstract FormUpdateDto sampleUpdateDto();

    @Override
    public FormResponseDto sampleCreateResponse(UUID id) {
        return new FormResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now(),  
                sampleEntity().getName(),
                sampleEntity().getVersion(),
                sampleFieldResponses()
        );
    }

    @Override
    public FormResponseDto sampleUpdateResponse(UUID id) {
        FormUpdateDto dto = sampleUpdateDto();

        return new FormResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now(),
                dto.name(),
                dto.version(),
                sampleUpdatedFieldResponses()
        );
    }

    @Override
    public Class<FormResponseDto> responseDtoClass() {
        return FormResponseDto.class;
    }

    // ---------- Helpers for children to reuse ----------

    protected abstract List<FormFieldCreateDto> sampleCreateFields();

    protected abstract List<FormFieldUpdateDto> sampleUpdateFields();

    protected List<FormFieldResponseDto> sampleFieldResponses() {
        return sampleCreateFields().stream()
                .map(form -> new FormFieldResponseDto(
                        null,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        form.label(),
                        form.type(),
                        form.orderIndex(),
                        form.required(),
                        form.placeholder(),
                        form.validationRegex(),
                        null
                ))
                .toList();
    }

    protected List<FormFieldResponseDto> sampleUpdatedFieldResponses() {
        return sampleUpdateFields().stream()
                .map(form -> new FormFieldResponseDto(
                        UUID.randomUUID(),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        form.label(),
                        form.type(),
                        form.orderIndex(),
                        Boolean.TRUE.equals(form.required()),
                        form.placeholder(),
                        form.validationRegex(),
                        null
                ))
                .toList();
    }
}
