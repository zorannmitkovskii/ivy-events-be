package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "event_categories")
public class EventCategory extends BaseEntity {

    @Column(nullable = false, length = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "icon_url", length = 500)
    private String iconUrl;

    @Builder.Default
    @Column(name = "is_active")
    private Boolean isActive = true;
}
