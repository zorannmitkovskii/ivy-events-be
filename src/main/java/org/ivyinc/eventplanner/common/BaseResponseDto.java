package org.ivyinc.eventplanner.common;

import java.time.LocalDateTime;
import java.util.UUID;

public interface BaseResponseDto {
    UUID id();
    LocalDateTime createdAt();
    LocalDateTime updatedAt();
}
