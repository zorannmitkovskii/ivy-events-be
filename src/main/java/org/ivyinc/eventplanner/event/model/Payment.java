package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {

    @Column(name = "event_id")
    private String eventId;

    @Column()
    private Double amount;

    @Column(length = 50)
    private String status;
}
