package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.FormSubmissionCreateDto;
import org.ivyinc.eventplanner.event.dto.FormSubmissionResponseDto;
import org.ivyinc.eventplanner.event.dto.FormSubmissionUpdateDto;
import org.ivyinc.eventplanner.event.model.FormSubmission;

import java.time.LocalDateTime;
import java.util.UUID;

public class FormSubmissionBuilder implements DtoBuilder<
        FormSubmission,
        FormSubmissionCreateDto,
        FormSubmissionUpdateDto,
        FormSubmissionResponseDto
        > {

    @Override
    public FormSubmission sampleEntity() {
        // The entity doesn't expose setters/getters here; a simple instance is enough for tests
        return new FormSubmission();
    }

    @Override
    public FormSubmissionCreateDto sampleCreateDto() {
        return new FormSubmissionCreateDto(
                "Wedding RSVP Submission",
                "Initial RSVP form submission for wedding event"
        );
    }

    @Override
    public FormSubmissionUpdateDto sampleUpdateDto() {
        return new FormSubmissionUpdateDto(
                "Updated Wedding RSVP Submission",
                "Updated notes for RSVP form submission"
        );
    }

    @Override
    public FormSubmissionResponseDto sampleCreateResponse(UUID id) {
        FormSubmissionCreateDto c = sampleCreateDto();
        return new FormSubmissionResponseDto(
                id,
                c.name(),
                c.description(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public FormSubmissionResponseDto sampleUpdateResponse(UUID id) {
        FormSubmissionUpdateDto u = sampleUpdateDto();
        return new FormSubmissionResponseDto(
                id,
                u.name(),
                u.description(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public Class<FormSubmissionResponseDto> responseDtoClass() {
        return FormSubmissionResponseDto.class;
    }

    // Context-specific sample data variant used by integration tests
    public static class WeddingFormSubmission extends FormSubmissionBuilder {
        @Override
        public FormSubmissionCreateDto sampleCreateDto() {
            return new FormSubmissionCreateDto(
                    "Wedding Dinner Preferences",
                    "Guest submitted dinner preferences via form"
            );
        }

        @Override
        public FormSubmissionUpdateDto sampleUpdateDto() {
            return new FormSubmissionUpdateDto(
                    "Wedding Dinner Preferences (Updated)",
                    "Guest updated dinner preferences"
            );
        }
    }
}
