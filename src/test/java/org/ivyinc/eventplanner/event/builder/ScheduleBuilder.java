package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.ContactResponseDto;
import org.ivyinc.eventplanner.event.dto.ScheduleCreateDto;
import org.ivyinc.eventplanner.event.dto.ScheduleResponseDto;
import org.ivyinc.eventplanner.event.dto.ScheduleUpdateDto;
import org.ivyinc.eventplanner.event.model.Event;
import org.ivyinc.eventplanner.event.model.Location;
import org.ivyinc.eventplanner.event.model.Schedule;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class ScheduleBuilder implements DtoBuilder<Schedule, ScheduleCreateDto, ScheduleUpdateDto, ScheduleResponseDto> {

    EventBuilder.TeamBuilding teamBuilding = new EventBuilder.TeamBuilding();
    EventBuilder.Wedding wedding = new EventBuilder.Wedding();

    // Shared test UUIDs for nested objects
    protected final UUID weddingId = wedding.sampleEntity().getId();
    protected final UUID teamBuildingId = teamBuilding.sampleEntity().getId();

    // ----------- Abstract methods to override -----------
    @Override
    public abstract Schedule sampleEntity();

    @Override
    public abstract ScheduleCreateDto sampleCreateDto();

    @Override
    public abstract ScheduleUpdateDto sampleUpdateDto();

    @Override
    public abstract ScheduleResponseDto sampleCreateResponse(UUID id);

    @Override
    public abstract ScheduleResponseDto sampleUpdateResponse(UUID id);

    @Override
    public Class<ScheduleResponseDto> responseDtoClass() {
        return ScheduleResponseDto.class;
    }

    // ======================================================================
    // 💍 Wedding Schedule
    // ======================================================================
    public static class WeddingSchedule extends ScheduleBuilder {

        @Override
        public Schedule sampleEntity() {
            return Schedule.builder()
                    .event(wedding.sampleEntity())
                    .startTime(LocalDateTime.of(2025, 6, 21, 15, 30))
                    .endTime(LocalDateTime.of(2025, 6, 21, 16, 30))
                    .orderIndex(1)
                    .description("Wedding ceremony at the main outdoor venue.")
                    .build();
        }

        @Override
        public ScheduleCreateDto sampleCreateDto() {
            return new ScheduleCreateDto(
                    weddingId,
                    LocalDateTime.of(2025, 6, 21, 15, 30),
                    LocalDateTime.of(2025, 6, 21, 16, 30),
                    1,
                    "Wedding ceremony at the main outdoor venue."
            );
        }

        @Override
        public ScheduleUpdateDto sampleUpdateDto() {
            return new ScheduleUpdateDto(
                    weddingId,
                    LocalDateTime.of(2025, 6, 21, 16, 0),
                    LocalDateTime.of(2025, 6, 21, 17, 0),
                    1,
                    "Updated schedule: Ceremony extended."
            );
        }

        @Override
        public ScheduleResponseDto sampleCreateResponse(UUID id) {
            Schedule entity = sampleEntity();
            return new ScheduleResponseDto(
                    id,
                    java.time.LocalDateTime.now(),
                    java.time.LocalDateTime.now(),
                    weddingId,
                    entity.getStartTime(),
                    entity.getEndTime(),
                    entity.getOrderIndex(),
                    entity.getDescription()
            );
        }
        @Override
        public ScheduleResponseDto sampleUpdateResponse(UUID id) {
            Schedule entity = sampleEntity();
            return new ScheduleResponseDto(
                    id,
                    java.time.LocalDateTime.now(),
                    java.time.LocalDateTime.now(),
                    weddingId,
                    entity.getStartTime(),
                    entity.getEndTime(),
                    entity.getOrderIndex(),
                    entity.getDescription()
            );
        }
    }

    // ======================================================================
    // 🏢 Team Building Schedule
    // ======================================================================
    public static class TeamBuildingSchedule extends ScheduleBuilder {

        @Override
        public Schedule sampleEntity() {
            return Schedule.builder()
                    .event(teamBuilding.sampleEntity())
                    .startTime(LocalDateTime.of(2025, 9, 10, 10, 0))
                    .endTime(LocalDateTime.of(2025, 9, 10, 12, 0))
                    .orderIndex(1)
                    .description("Ice-breaker outdoor activity and group warm-up.")
                    .build();
        }

        @Override
        public ScheduleCreateDto sampleCreateDto() {
            return new ScheduleCreateDto(
                    teamBuildingId,
                    LocalDateTime.of(2025, 9, 10, 10, 0),
                    LocalDateTime.of(2025, 9, 10, 12, 0),
                    1,
                    "Ice-breaker outdoor activity and group warm-up."
            );
        }

        @Override
        public ScheduleUpdateDto sampleUpdateDto() {
            return new ScheduleUpdateDto(
                    teamBuildingId,
                    LocalDateTime.of(2025, 9, 10, 11, 0),
                    LocalDateTime.of(2025, 9, 10, 13, 0),
                    2,
                    "Updated schedule: Extended group warm-up and preparation."
            );
        }

        @Override
        public ScheduleResponseDto sampleCreateResponse(UUID id) {
            Schedule entity = sampleEntity();
            return new ScheduleResponseDto(
                    id,
                    java.time.LocalDateTime.now(),
                    java.time.LocalDateTime.now(),
                    teamBuildingId,
                    entity.getStartTime(),
                    entity.getEndTime(),
                    entity.getOrderIndex(),
                    entity.getDescription()
            );
        }
        @Override
        public ScheduleResponseDto sampleUpdateResponse(UUID id) {
            Schedule entity = sampleEntity();
            return new ScheduleResponseDto(
                    id,
                    java.time.LocalDateTime.now(),
                    java.time.LocalDateTime.now(),
                    teamBuildingId,
                    entity.getStartTime(),
                    entity.getEndTime(),
                    entity.getOrderIndex(),
                    entity.getDescription()
            );
        }
    }
}
