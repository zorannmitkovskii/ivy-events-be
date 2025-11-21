package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.EventInfoCreateDto;
import org.ivyinc.eventplanner.event.dto.EventInfoResponseDto;
import org.ivyinc.eventplanner.event.dto.EventInfoUpdateDto;
import org.ivyinc.eventplanner.event.model.EventInfo;
import org.hibernate.annotations.JdbcTypeCode;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EventInfoBuilder implements DtoBuilder<EventInfo, EventInfoCreateDto, EventInfoUpdateDto, EventInfoResponseDto> {

    @Override
    public EventInfo sampleEntity() {
        Map<String, Object> agenda = new HashMap<>();
        agenda.put("welcome", "18:00");
        Map<String, Object> tags = new HashMap<>();
        tags.put("theme", "gala");
        return EventInfo.builder()
                .formId(UUID.randomUUID())
                .note("Notes about event info")
                .version(1)
                .contactPerson("John Doe")
                .phoneNumber("+38970000000")
                .email("john@example.com")
                .agenda(agenda)
                .tags(tags)
                .build();
    }

    @Override
    public EventInfoCreateDto sampleCreateDto() {
        Map<String, Object> agenda = new HashMap<>();
        agenda.put("welcome", "18:00");
        Map<String, Object> tags = new HashMap<>();
        tags.put("theme", "gala");
        return new EventInfoCreateDto(
                UUID.randomUUID(),
                "Notes about event info",
                1,
                "John Doe",
                "+38970000000",
                "john@example.com",
                agenda,
                tags
        );
    }

    @Override
    public EventInfoUpdateDto sampleUpdateDto() {
        return new EventInfoUpdateDto(UUID.randomUUID());
    }

    @Override
    public EventInfoResponseDto sampleCreateResponse(UUID id) {
        return new EventInfoResponseDto(id, LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public EventInfoResponseDto sampleUpdateResponse(UUID id) {
        return new EventInfoResponseDto(id, LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public Class<EventInfoResponseDto> responseDtoClass() {
        return EventInfoResponseDto.class;
    }
}
