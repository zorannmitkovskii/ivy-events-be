package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;
import org.ivyinc.eventplanner.event.enums.InviteStatus;
import org.ivyinc.eventplanner.event.enums.NotificationType;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "guests")
public class Guest extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Column(name = "table_number", length = 50)
    private String tableNumber;

    // Renamed from dietaryPreferences (JSON Map) to dieatary and switched to entity relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dieatary_id")
    private Dietary dieatary;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type", length = 50)
    private NotificationType notificationType;

    @Enumerated(EnumType.STRING)
    @Column(name = "invite_status", length = 50)
    private InviteStatus inviteStatus;

    @Column(name = "num_of_guests")
    private Integer numOfGuests;

    @Column(name = "rsvp_date")
    private LocalDateTime rsvpDate;

    @Column(name = "is_vip")
    private Boolean isVip;

    @Column(name = "check_in_status")
    private Boolean checkInStatus;
}
