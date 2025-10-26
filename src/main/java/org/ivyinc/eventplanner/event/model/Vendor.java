package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vendors")
public class Vendor extends BaseEntity {

    private String name;

    @Column(name = "vendor_type", length = 100)
    private String vendorType;

    @Column(name = "contact_id")
    private String contactId;

    @Column(length = 500)
    private String website;

    @Column(name = "instagram_url", length = 500)
    private String instagramUrl;

    @Column(precision = 3, scale = 2)
    private java.math.BigDecimal rating;

    @Column(name = "is_active")
    private Boolean active;
}
