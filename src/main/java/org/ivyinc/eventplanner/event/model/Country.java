package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ivyinc.eventplanner.common.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

    @Column(name = "iso2", length = 2, nullable = false, unique = true)
    private String iso2;

    @Column(name = "iso3", length = 3, nullable = false, unique = true)
    private String iso3;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "flag", length = 20)
    private String flag;
}
