package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.event.enums.EventType;
import org.ivyinc.eventplanner.event.common.BaseEntity;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "events")
public class Event extends BaseEntity {

    private String ownerId;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EventType type;

    @Column(name = "date_time", nullable = false)
    private Instant dateTime;

    @Column(length = 255)
    private String venue;

    @Column(name = "cover_image", columnDefinition = "TEXT")
    private String coverImage;

    @Column(name = "estimated_budget", precision = 12, scale = 2)
    private BigDecimal estimatedBudget;

    @Column(name = "theme_color", length = 20)
    private String themeColor;

    @Column(name = "rsvp_deadline")
    private Instant rsvpDeadline;

    @Column(name = "is_photo_upload_enabled")
    private boolean isPhotoUploadEnabled = false;

    @Column(name = "is_public")
    private boolean isPublic = false;

    @Column(name = "public_code", length = 50, unique = true)
    private String publicCode;
}
