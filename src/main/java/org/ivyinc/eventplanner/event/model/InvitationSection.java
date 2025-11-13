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
@Table(name = "sections")
public class InvitationSection extends BaseEntity {

    @Column(name = "template_id")
    private String templateId;

    private String name;

    @Column(name = "section_type", length = 50)
    private String sectionType;

    private String path;

    @Column(name = "order_index")
    private Integer orderIndex;

    @Column(name = "is_required")
    private Boolean isRequired;
}
