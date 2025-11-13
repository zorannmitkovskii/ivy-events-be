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
@Table(name = "event_info")
public class EventInfo extends BaseEntity {

    @Column(name = "form_id")
    private String formId;

    @Column(columnDefinition = "TEXT")
    private String note;

    private Integer version;
}
