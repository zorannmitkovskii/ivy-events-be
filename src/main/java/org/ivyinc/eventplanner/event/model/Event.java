package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;
import org.ivyinc.eventplanner.event.enums.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "events")
public class Event extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_type_id")
    private EventType eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_info_id")
    private EventInfo eventInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizer_id")
    private Contact organizer;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "agenda_id")
    private UUID agendaId;

    @Column(name = "max_guests")
    private Integer maxGuests;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type", length = 100)
    private NotificationType notificationType;

    // Map to unique_url in migration, used as public code
    @Column(name = "unique_url", unique = true)
    private String publicCode;

    @Column(name = "cover_image_url", length = 500)
    private String coverImageUrl;

    @Column(length = 100)
    private String timezone;

    @Column(length = 50)
    private String status;

    @Column(length = 50)
    private String visibility;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "last_updated_by")
    private UUID lastUpdatedBy;
}
