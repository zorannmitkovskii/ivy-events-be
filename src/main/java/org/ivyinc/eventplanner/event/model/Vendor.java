package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;

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
    private String vendorType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Column(length = 500)
    private String website;

    @Column(name = "instagram_url", length = 500)
    private String instagramUrl;

    @Column()
    private Double rating;

    @Column(name = "is_active")
    private Boolean active;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "package_id")
    private List<Package> packages;
}
