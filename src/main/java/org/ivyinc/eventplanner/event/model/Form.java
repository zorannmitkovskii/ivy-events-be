package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Form  extends BaseEntity {

    private String name;

    private Integer version;

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FormField> fields;
}
