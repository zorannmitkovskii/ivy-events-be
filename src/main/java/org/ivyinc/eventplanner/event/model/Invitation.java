package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.event.common.BaseEntity;
import org.ivyinc.eventplanner.event.enums.InvitationStatus;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "invitations")
public class Invitation extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "contact_name", nullable = false, length = 255)
    private String contactName;

    @Column(name = "contact_email_or_phone", nullable = false, length = 255)
    private String contactEmailOrPhone;

    @Column(name = "guest_limit")
    private Integer guestLimit;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private InvitationStatus status;

    @Column(name = "response_date")
    private Instant responseDate;

    @Column(name = "message_from_contact", columnDefinition = "TEXT")
    private String messageFromContact;

    @Column(name = "public_code", unique = true, length = 50)
    private String publicCode;
}
