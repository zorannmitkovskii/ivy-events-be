package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.CountryCreateDto;
import org.ivyinc.eventplanner.event.dto.CountryResponseDto;
import org.ivyinc.eventplanner.event.dto.CountryUpdateDto;
import org.ivyinc.eventplanner.event.model.Country;

import java.time.LocalDateTime;
import java.util.UUID;

public class CountryBuilder implements DtoBuilder<Country, CountryCreateDto, CountryUpdateDto, CountryResponseDto> {

    @Override
    public Country sampleEntity() {
        Country c = new Country();
        c.setIso2("MK");
        c.setIso3("MKD");
        c.setCountryName("North Macedonia");
        c.setFlag("🇲🇰");
        return c;
    }

    @Override
    public CountryCreateDto sampleCreateDto() {
        return new CountryCreateDto(
                "MK",
                "MKD",
                "North Macedonia",
                "🇲🇰"
        );
    }

    @Override
    public CountryUpdateDto sampleUpdateDto() {
        return new CountryUpdateDto(
                "AL",
                "ALB",
                "Albania",
                "🇦🇱"
        );
    }

    @Override
    public CountryResponseDto sampleCreateResponse(UUID id) {
        return new CountryResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "MK",
                "MKD",
                "North Macedonia",
                "🇲🇰"
        );
    }

    @Override
    public CountryResponseDto sampleUpdateResponse(UUID id) {
        return new CountryResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now(),
                sampleUpdateDto().iso2(),
                sampleUpdateDto().iso3(),
                sampleUpdateDto().countryName(),
                sampleUpdateDto().flag()
        );
    }

    @Override
    public Class<CountryResponseDto> responseDtoClass() {
        return CountryResponseDto.class;
    }
}
