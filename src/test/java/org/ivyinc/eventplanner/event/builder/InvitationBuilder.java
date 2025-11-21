package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.InvitationCreateDto;
import org.ivyinc.eventplanner.event.dto.InvitationResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationUpdateDto;
import org.ivyinc.eventplanner.event.model.Invitation;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class InvitationBuilder implements DtoBuilder<Invitation, InvitationCreateDto, InvitationUpdateDto, InvitationResponseDto> {

    @Override
    public abstract Invitation sampleEntity();

    @Override
    public InvitationCreateDto sampleCreateDto() {
        return new InvitationCreateDto();
    }

    @Override
    public InvitationUpdateDto sampleUpdateDto() {
        return new InvitationUpdateDto();
    }

    @Override
    public InvitationResponseDto sampleCreateResponse(UUID id) {
        return new InvitationResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public InvitationResponseDto sampleUpdateResponse(UUID id) {
        return new InvitationResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public Class<InvitationResponseDto> responseDtoClass() {
        return InvitationResponseDto.class;
    }

    // Concrete variants
    public static class Wedding extends InvitationBuilder {
        private final EventBuilder.Wedding weddingEventBuilder = new EventBuilder.Wedding();
        @Override
        public Invitation sampleEntity() {
            return Invitation.builder()
                    .event(weddingEventBuilder.sampleEntity())
                    .publicCode("WED-INV-001")
                    .active(true)
                    .viewCount(0)
                    .build();
        }
    }

    public static class TeamBuilding extends InvitationBuilder {
        private final EventBuilder.TeamBuilding teamBuildingEventBuilder = new EventBuilder.TeamBuilding();
        @Override
        public Invitation sampleEntity() {
            return Invitation.builder()
                    .event(teamBuildingEventBuilder.sampleEntity())
                    .publicCode("TEAM-INV-001")
                    .active(true)
                    .viewCount(0)
                    .build();
        }
    }
}
