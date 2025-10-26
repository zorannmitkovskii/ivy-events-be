package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;
import org.ivyinc.eventplanner.event.enums.LocationType;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

    private String name;

    @Column(name = "address_line")
    private String addressLine;

    private String city;

    private String country;

    private BigDecimal latitude;

    private BigDecimal longitude;

    @Column(name = "google_maps_url")
    private String googleMapsUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer capacity;

    private String notes;

    @Column(name = "contact_id")
    private String contactId;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private LocationType type;

    @Column(name = "is_active")
    private Boolean active;
}
