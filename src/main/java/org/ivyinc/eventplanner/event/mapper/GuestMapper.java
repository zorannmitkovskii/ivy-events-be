package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.GuestCreateDto;
import org.ivyinc.eventplanner.event.dto.GuestResponseDto;
import org.ivyinc.eventplanner.event.dto.GuestUpdateDto;
import org.ivyinc.eventplanner.event.model.Guest;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GuestMapper extends BaseMapper<Guest, GuestCreateDto, GuestUpdateDto, GuestResponseDto>{
}