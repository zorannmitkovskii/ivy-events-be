package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.ivyinc.eventplanner.common.BaseEntity;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "event_info")
public class EventInfo extends BaseEntity {

    @Column(name = "form_id")
    private UUID formId;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Builder.Default
    private Integer version = 1;

    @Column(name = "contact_person", length = 255)
    private String contactPerson;

    @Column(name = "phone_number", length = 50)
    private String phoneNumber;

    @Column(length = 255)
    private String email;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "JSON")
    private Map<String, Object> agenda;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "JSON")
    private Map<String, Object> tags;
}
