package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "expenses")
public class Expense extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_id")
    private Budget budget;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column()
    private BigDecimal amount;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "payment_status", length = 50)
    private String paymentStatus;

    @Column(name = "payment_method", length = 50)
    private String paymentMethod;

    @Column(name = "receipt_url", length = 500)
    private String receiptUrl;
}
