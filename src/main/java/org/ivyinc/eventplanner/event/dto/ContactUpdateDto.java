package org.ivyinc.eventplanner.event.dto;

public record ContactUpdateDto(
        String name,
        String email,
        String phone) {
}
