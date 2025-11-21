package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import org.ivyinc.eventplanner.common.BaseEntity;

@Entity
public class FormFieldAnswer  extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private FormField field;

    @ManyToOne(fetch = FetchType.LAZY)
    private FormSubmission submission;

    @Column(length = 4096)
    private String answer;

}
