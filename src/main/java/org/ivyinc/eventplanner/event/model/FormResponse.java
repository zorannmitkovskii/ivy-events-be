package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "responses")
public class FormResponse extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id")
    private FormField field;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(columnDefinition = "TEXT")
    private String answer;

    @Column(name = "response_status", length = 50)
    private String responseStatus;

    @Column(name = "submitted_by_ip", length = 50)
    private String submittedByIp;

    @Column(name = "submitted_at")
    private Instant submittedAt;
}
