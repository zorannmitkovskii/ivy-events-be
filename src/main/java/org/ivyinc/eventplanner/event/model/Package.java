package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "packages")
public class Package extends BaseEntity {

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column()
    private BigDecimal price;

    @Column(name = "price_currency", length = 10)
    private String priceCurrency;

    @Column(name = "video_url", length = 500)
    private String videoUrl;

    @ManyToMany
    @JoinTable(
            name = "vendor_packages",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "vendor_id")
    )
    @Builder.Default
    private List<Vendor> vendors = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "location_packages",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    @Builder.Default
    private List<Location> locations = new ArrayList<>();
}
