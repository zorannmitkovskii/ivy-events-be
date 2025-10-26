package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.ivyinc.eventplanner.common.BaseEntity;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {

    @Column(name = "event_id")
    private Long eventId;

    @Column(precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(length = 50)
    private String status;
}
