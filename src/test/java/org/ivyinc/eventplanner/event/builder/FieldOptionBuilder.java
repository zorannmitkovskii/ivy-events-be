package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.FieldOptionCreateDto;
import org.ivyinc.eventplanner.event.dto.FieldOptionResponseDto;
import org.ivyinc.eventplanner.event.dto.FieldOptionUpdateDto;
import org.ivyinc.eventplanner.event.model.FieldOption;

import java.util.UUID;

public class FieldOptionBuilder implements DtoBuilder<
        FieldOption,
        FieldOptionCreateDto,
        FieldOptionUpdateDto,
        FieldOptionResponseDto
        > {

    @Override
    public FieldOption sampleEntity() {
        return FieldOption.builder()
                .value("Option A")
                .orderIndex(1)
                .build();
    }

    @Override
    public FieldOptionCreateDto sampleCreateDto() {
        return new FieldOptionCreateDto("Option A", 1);
    }

    @Override
    public FieldOptionUpdateDto sampleUpdateDto() {
        return new FieldOptionUpdateDto(
                UUID.randomUUID(), // formId (not used by mapper in tests, just placeholder)
                "Option A (updated)",
                2
        );
    }

    @Override
    public FieldOptionResponseDto sampleCreateResponse(UUID id) {
        return new FieldOptionResponseDto(id, sampleCreateDto().value(), sampleCreateDto().orderIndex());
    }

    @Override
    public FieldOptionResponseDto sampleUpdateResponse(UUID id) {
        FieldOptionUpdateDto dto = sampleUpdateDto();
        return new FieldOptionResponseDto(id, dto.value(), dto.orderIndex());
    }

    @Override
    public Class<FieldOptionResponseDto> responseDtoClass() {
        return FieldOptionResponseDto.class;
    }

    // Convenience variants for specific option values
    public static class Yes extends FieldOptionBuilder {
        @Override
        public FieldOption sampleEntity() {
            return FieldOption.builder().value("Yes").orderIndex(1).build();
        }
        @Override
        public FieldOptionCreateDto sampleCreateDto() { return new FieldOptionCreateDto("Yes", 1); }
    }

    public static class No extends FieldOptionBuilder {
        @Override
        public FieldOption sampleEntity() {
            return FieldOption.builder().value("No").orderIndex(2).build();
        }
        @Override
        public FieldOptionCreateDto sampleCreateDto() { return new FieldOptionCreateDto("No", 2); }
    }
}
