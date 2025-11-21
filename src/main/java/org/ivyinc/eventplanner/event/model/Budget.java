package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column()
    private BigDecimal amount;

    @Column(name = "remain_amount")
    private BigDecimal remainAmount;

    @Column(length = 10)
    private String currency;
}
