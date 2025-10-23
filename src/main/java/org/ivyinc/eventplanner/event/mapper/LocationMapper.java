package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.event.dto.LocationUpdateDto;
import org.ivyinc.eventplanner.event.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    Location updateLocationFromDto(LocationUpdateDto dto, @MappingTarget Location entity);
}