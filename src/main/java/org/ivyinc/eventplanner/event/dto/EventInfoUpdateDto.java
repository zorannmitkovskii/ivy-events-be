package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;

import java.util.UUID;

public record EventInfoUpdateDto(UUID id) implements BaseUpdateRequestDto {
}
