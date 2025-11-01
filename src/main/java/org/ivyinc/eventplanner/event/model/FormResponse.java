package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    @Column(name = "field_id")
    private Long fieldId;

    @Column(name = "guest_id")
    private Long guestId;

    @Column(name = "event_id")
    private Long eventId;

    @Column(columnDefinition = "TEXT")
    private String answer;

    @Column(name = "submitted_at")
    private Instant submittedAt;
}
