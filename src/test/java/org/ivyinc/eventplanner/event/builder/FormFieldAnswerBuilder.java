package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.FormFieldAnswerCreateDto;
import org.ivyinc.eventplanner.event.dto.FormFieldAnswerResponseDto;
import org.ivyinc.eventplanner.event.dto.FormFieldAnswerUpdateDto;
import org.ivyinc.eventplanner.event.model.FormFieldAnswer;

import java.time.LocalDateTime;
import java.util.UUID;

public class FormFieldAnswerBuilder implements DtoBuilder<
        FormFieldAnswer,
        FormFieldAnswerCreateDto,
        FormFieldAnswerUpdateDto,
        FormFieldAnswerResponseDto
        > {

    @Override
    public FormFieldAnswer sampleEntity() {
        return new FormFieldAnswer();
    }

    @Override
    public FormFieldAnswerCreateDto sampleCreateDto() {
        return new FormFieldAnswerCreateDto(
                "Meal Preference Answer",
                "Answered: Vegetarian"
        );
    }

    @Override
    public FormFieldAnswerUpdateDto sampleUpdateDto() {
        return new FormFieldAnswerUpdateDto(
                "Meal Preference Answer (Updated)",
                "Answered: Vegan"
        );
    }

    @Override
    public FormFieldAnswerResponseDto sampleCreateResponse(UUID id) {
        FormFieldAnswerCreateDto c = sampleCreateDto();
        return new FormFieldAnswerResponseDto(
                id,
                c.name(),
                c.description(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public FormFieldAnswerResponseDto sampleUpdateResponse(UUID id) {
        FormFieldAnswerUpdateDto u = sampleUpdateDto();
        return new FormFieldAnswerResponseDto(
                id,
                u.name(),
                u.description(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public Class<FormFieldAnswerResponseDto> responseDtoClass() {
        return FormFieldAnswerResponseDto.class;
    }

    // Variant used in ITs
    public static class WeddingFormFieldAnswer extends FormFieldAnswerBuilder {
        @Override
        public FormFieldAnswerCreateDto sampleCreateDto() {
            return new FormFieldAnswerCreateDto(
                    "Wedding Seating Note",
                    "Answered: Table 5, Seat 2"
            );
        }

        @Override
        public FormFieldAnswerUpdateDto sampleUpdateDto() {
            return new FormFieldAnswerUpdateDto(
                    "Wedding Seating Note (Updated)",
                    "Answered: Table 3, Seat 6"
            );
        }
    }
}
