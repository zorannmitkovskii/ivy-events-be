package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.LocationCreateDto;
import org.ivyinc.eventplanner.event.dto.LocationResponseDto;
import org.ivyinc.eventplanner.event.dto.LocationUpdateDto;
import org.ivyinc.eventplanner.event.model.Country;
import org.ivyinc.eventplanner.event.model.Location;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LocationMapper extends BaseMapper<Location, LocationCreateDto, LocationUpdateDto, LocationResponseDto> {

    @Override
    @Mappings({
            @Mapping(target = "country", ignore = true)
    })
    Location toEntity(LocationCreateDto dto);

    @Override
    @Mappings({
            @Mapping(target = "country", ignore = true)
    })
    void updateEntity(@MappingTarget Location entity, LocationUpdateDto dto);

    @Override
    LocationResponseDto toResponse(Location entity);
}