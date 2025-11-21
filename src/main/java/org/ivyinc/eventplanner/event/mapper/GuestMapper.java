package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.GuestCreateDto;
import org.ivyinc.eventplanner.event.dto.GuestResponseDto;
import org.ivyinc.eventplanner.event.dto.GuestUpdateDto;
import org.ivyinc.eventplanner.event.model.Guest;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {DietaryMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GuestMapper extends BaseMapper<Guest, GuestCreateDto, GuestUpdateDto, GuestResponseDto>{

    @Override
    @Mappings({
            @Mapping(target = "contact", ignore = true),
            @Mapping(target = "dieatary", ignore = true)
    })
    Guest toEntity(GuestCreateDto dto);

    @Override
    @Mappings({
            @Mapping(target = "contact", ignore = true),
            @Mapping(target = "dieatary", ignore = true)
    })
    void updateEntity(@MappingTarget Guest entity, GuestUpdateDto dto);

    @Override
    @Mappings({
            @Mapping(target = "dietaryPreferences", source = "dieatary")
    })
    GuestResponseDto toResponse(Guest entity);
}