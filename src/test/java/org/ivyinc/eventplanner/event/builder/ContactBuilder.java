package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.model.Contact;

import java.time.LocalDateTime;
import java.util.UUID;

public class ContactBuilder implements DtoBuilder<Contact, ContactCreateDto, ContactUpdateDto, ContactResponseDto> {
    @Override
    public Contact sampleEntity() {
        return new Contact(
                "John Doe",
                "john@example.com",
                "+38970123456"
        );
    }

    @Override
    public ContactCreateDto sampleCreateDto() {
        return new ContactCreateDto(
                "John Doe",
                "john@example.com",
                "+38970123456"
        );
    }

    @Override
    public ContactUpdateDto sampleUpdateDto() {
        return new ContactUpdateDto(
                "Jane Doe",
                "jane@example.com",
                "+38970123457"
        );
    }

    @Override
    public ContactResponseDto sampleCreateResponse(UUID id) {
        return new ContactResponseDto(
                id,
                "John Doe",
                "john@example.com",
                "+38970123456",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public ContactResponseDto sampleUpdateResponse(UUID id) {
        return new ContactResponseDto(
                id,
                "Jane Doe",
                "jane@example.com",
                "+38970123457",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public Class<ContactResponseDto> responseDtoClass() {
        return ContactResponseDto.class;
    }

    // Nested specializations used by other builders
    public static class WeddingContact extends ContactBuilder {
        @Override
        public Contact sampleEntity() {
            return new Contact(
                    "Wedding Planner",
                    "wedding.planner@example.com",
                    "+38970111222"
            );
        }

        @Override
        public ContactCreateDto sampleCreateDto() {
            return new ContactCreateDto(
                    "Wedding Planner",
                    "wedding.planner@example.com",
                    "+38970111222"
            );
        }

        @Override
        public ContactUpdateDto sampleUpdateDto() {
            return new ContactUpdateDto(
                    "Wedding Planner Updated",
                    "wedding.planner.updated@example.com",
                    "+38970111223"
            );
        }
    }

    public static class TeamBuildingContact extends ContactBuilder {
        @Override
        public Contact sampleEntity() {
            return new Contact(
                    "Team Lead",
                    "team.lead@example.com",
                    "+38970999888"
            );
        }

        @Override
        public ContactCreateDto sampleCreateDto() {
            return new ContactCreateDto(
                    "Team Lead",
                    "team.lead@example.com",
                    "+38970999888"
            );
        }

        @Override
        public ContactUpdateDto sampleUpdateDto() {
            return new ContactUpdateDto(
                    "Team Lead Updated",
                    "team.lead.updated@example.com",
                    "+38970999889"
            );
        }
    }
}
