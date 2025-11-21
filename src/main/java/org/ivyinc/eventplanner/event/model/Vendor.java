package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;
import org.ivyinc.eventplanner.event.enums.VendorType;
import org.ivyinc.eventplanner.event.enums.AvailabilityStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    private VendorType type;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Column(length = 500)
    private String website;

    @Column(name = "instagram_url", length = 500)
    private String instagramUrl;

    @Column(name = "service_area", length = 255)
    private String serviceArea;

    @Enumerated(EnumType.STRING)
    @Column(name = "availability_status", length = 50)
    private AvailabilityStatus availabilityStatus;

    @Column(name = "contract_url", length = 500)
    private String contractUrl;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @ManyToMany(mappedBy = "vendors")
    private List<Package> packages = new ArrayList<>();
}
