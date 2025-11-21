package org.ivyinc.eventplanner.event.dto;

import org.ivyinc.eventplanner.common.BaseUpdateRequestDto;

import java.util.UUID;

public record FeedbackUpdateDto(
        UUID eventId,
        UUID guestId,
        UUID vendorId,
        Integer rating,
        String comment,
        String mediaUrl) implements BaseUpdateRequestDto {
}
