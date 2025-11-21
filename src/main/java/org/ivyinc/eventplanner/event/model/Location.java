package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.ivyinc.eventplanner.common.BaseEntity;
import org.ivyinc.eventplanner.event.enums.LocationType;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private LocationType type;  // added (was at the bottom before, moved logically near name)

    @Column(name = "address_line")
    private String addressLine;

    @Column(name = "postal_code", length = 50)
    private String postalCode;  // added

    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_iso3", referencedColumnName = "iso3", nullable = false)
    private Country country;

    private Double latitude;

    private Double longitude;

    @Column(name = "google_maps_url", length = 500)
    private String googleMapsUrl;

    @Column(name = "photo_url", length = 500)
    private String photoUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer capacity;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "opening_hours", columnDefinition = "JSON")
    private Map<String, Object> openingHours;

    private String notes;

    @Column(name = "contact_id")
    private UUID contactId;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @ManyToMany(mappedBy = "locations")
    @Builder.Default
    private java.util.List<Package> packages = new java.util.ArrayList<>();
}
