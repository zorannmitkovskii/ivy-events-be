package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.enums.FieldType;
import org.ivyinc.eventplanner.event.model.FormField;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class FormFieldBuilder implements DtoBuilder<
        FormField,
        FormFieldCreateDto,
        FormFieldUpdateDto,
        FormFieldResponseDto
        > {

    private final FieldOptionBuilder.Yes yesOption = new FieldOptionBuilder.Yes();
    private final FieldOptionBuilder.No noOption = new FieldOptionBuilder.No();

    @Override
    public FormField sampleEntity() {
        return FormField.builder()
                .label("Full Name")
                .type(FieldType.TEXT)
                .orderIndex(1)
                .required(true)
                .placeholder("Enter your full name")
                .validationRegex(null)
                .build();
    }

    @Override
    public FormFieldCreateDto sampleCreateDto() {
        return new FormFieldCreateDto(
                "Full Name",
                FieldType.TEXT,
                1,
                true,
                "Enter your full name",
                null,
                List.of()
        );
    }

    @Override
    public FormFieldUpdateDto sampleUpdateDto() {
        return new FormFieldUpdateDto(
                UUID.randomUUID(),
                "Full Name (updated)",
                FieldType.TEXT,
                1,
                true,
                "Please enter your full name",
                null,
                List.of()
        );
    }

    @Override
    public FormFieldResponseDto sampleCreateResponse(UUID id) {
        FormFieldCreateDto dto = sampleCreateDto();
        return new FormFieldResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now(),
                dto.label(),
                dto.type(),
                dto.orderIndex(),
                dto.required(),
                dto.placeholder(),
                dto.validationRegex(),
                List.of()
        );
    }

    @Override
    public FormFieldResponseDto sampleUpdateResponse(UUID id) {
        FormFieldUpdateDto dto = sampleUpdateDto();
        return new FormFieldResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now(),
                dto.label(),
                dto.type(),
                dto.orderIndex(),
                Boolean.TRUE.equals(dto.required()),
                dto.placeholder(),
                dto.validationRegex(),
                List.of()
        );
    }

    @Override
    public Class<FormFieldResponseDto> responseDtoClass() {
        return FormFieldResponseDto.class;
    }

    // Convenience variants
    public static class EmailField extends FormFieldBuilder {
        @Override
        public FormField sampleEntity() {
            return FormField.builder()
                    .label("Email")
                    .type(FieldType.EMAIL)
                    .orderIndex(2)
                    .required(true)
                    .placeholder("name@example.com")
                    .validationRegex(null)
                    .build();
        }
        @Override
        public FormFieldCreateDto sampleCreateDto() {
            return new FormFieldCreateDto(
                    "Email",
                    FieldType.EMAIL,
                    2,
                    true,
                    "name@example.com",
                    null,
                    List.of()
            );
        }
        @Override
        public FormFieldUpdateDto sampleUpdateDto() {
            return new FormFieldUpdateDto(
                    UUID.randomUUID(),
                    "Email (updated)",
                    FieldType.EMAIL,
                    2,
                    true,
                    "your.name@example.com",
                    null,
                    List.of()
            );
        }
    }

    public static class YesNoSelectField extends FormFieldBuilder {
        private final FieldOptionBuilder.Yes yes = new FieldOptionBuilder.Yes();
        private final FieldOptionBuilder.No no = new FieldOptionBuilder.No();
        @Override
        public FormField sampleEntity() {
            return FormField.builder()
                    .label("Subscribe to newsletter?")
                    .type(FieldType.SELECT)
                    .orderIndex(3)
                    .required(false)
                    .placeholder(null)
                    .validationRegex(null)
                    .build();
        }
        @Override
        public FormFieldCreateDto sampleCreateDto() {
            return new FormFieldCreateDto(
                    "Subscribe to newsletter?",
                    FieldType.SELECT,
                    3,
                    false,
                    null,
                    null,
                    List.of(
                            yes.sampleCreateDto(),
                            no.sampleCreateDto()
                    )
            );
        }
        @Override
        public FormFieldResponseDto sampleCreateResponse(UUID id) {
            var c = sampleCreateDto();
            return new FormFieldResponseDto(
                    id,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    c.label(),
                    c.type(),
                    c.orderIndex(),
                    c.required(),
                    c.placeholder(),
                    c.validationRegex(),
                    List.of(
                            yes.sampleCreateResponse(UUID.randomUUID()),
                            no.sampleCreateResponse(UUID.randomUUID())
                    )
            );
        }
    }
}
