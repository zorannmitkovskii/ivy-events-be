package org.ivyinc.eventplanner.event.dto;

public record ContactCreateDto(
        String name,
        String email,
        String phone) {
}
