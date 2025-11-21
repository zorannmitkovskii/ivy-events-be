package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import org.ivyinc.eventplanner.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
public class FormSubmission  extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Form form;

    private String submittedBy;

    private LocalDateTime submittedAt;
}
