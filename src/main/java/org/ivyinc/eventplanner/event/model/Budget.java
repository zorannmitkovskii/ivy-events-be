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
@Table(name = "budgets")
public class Budget extends BaseEntity {

    @Column(name = "event_id")
    private Long eventId;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "remain_amount", precision = 10, scale = 2)
    private BigDecimal remainAmount;
}
