package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;

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

    @Column(name = "template_id")
    private Long templateId;

    @Column(name = "form_id")
    private Long formId;

    // Store JSON as text for simplicity
    @Column(name = "custom_sections", columnDefinition = "TEXT")
    private String customSections;

    // Map to unique_url
    @Column(name = "unique_url", unique = true)
    private String publicCode;

    @Column(name = "is_active")
    private Boolean active;
}
