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
@Table(name = "fields")
public class FormField extends BaseEntity {

    @Column(name = "form_id")
    private String formId;

    private String question;

    @Column(name = "field_type", length = 50)
    private String fieldType;

    // Store JSON options as TEXT
    @Column(columnDefinition = "TEXT")
    private String options;

    @Column(name = "is_required")
    private Boolean required;

    @Column(name = "field_order")
    private Integer fieldOrder;
}
