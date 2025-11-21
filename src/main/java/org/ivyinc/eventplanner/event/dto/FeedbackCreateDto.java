package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseCreateRequestDto;

import java.util.UUID;

public record FeedbackCreateDto(
        UUID eventId,
        UUID guestId,
        UUID vendorId,
        Integer rating,
        String comment,
        String mediaUrl
) implements BaseCreateRequestDto {
}
