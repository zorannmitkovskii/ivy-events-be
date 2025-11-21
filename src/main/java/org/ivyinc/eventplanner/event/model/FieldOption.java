package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "field_options")
public class FieldOption extends BaseEntity {

    private String value;

    private Integer orderIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    private FormField formField;
}
