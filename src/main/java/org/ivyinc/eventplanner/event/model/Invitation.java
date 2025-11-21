package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.ivyinc.eventplanner.common.BaseEntity;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "invitations")
public class Invitation extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id")
    private InvitationTemplate template;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id")
    private Form form;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "custom_sections")
    private Map<String, Object> customSections;

    @Column(name = "unique_url", unique = true)
    private String publicCode;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;

    @Column(name = "view_count")
    private Integer viewCount;

    @Column(name = "last_viewed_at")
    private LocalDateTime lastViewedAt;

    @Column(name = "rsvp_token")
    private String rsvpToken;

    @Column(name = "is_active")
    private Boolean active = true;
}
