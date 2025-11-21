package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;
import org.ivyinc.eventplanner.event.enums.FieldType;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fields")
public class FormField extends BaseEntity {

    private String label;

    @Enumerated(EnumType.STRING)
    private FieldType type;

    private Integer orderIndex;

    private boolean required;

    @Column(length = 2048)
    private String placeholder;

    @Column(length = 4096)
    private String validationRegex;

    @ManyToOne(fetch = FetchType.LAZY)
    private Form form;
}
