package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.CountryCreateDto;
import org.ivyinc.eventplanner.event.dto.CountryResponseDto;
import org.ivyinc.eventplanner.event.dto.CountryUpdateDto;
import org.ivyinc.eventplanner.event.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CountryMapper extends BaseMapper<Country, CountryCreateDto, CountryUpdateDto, CountryResponseDto> {
}
