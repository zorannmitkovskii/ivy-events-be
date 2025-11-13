package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.EventInfoCreateDto;
import org.ivyinc.eventplanner.event.dto.EventInfoResponseDto;
import org.ivyinc.eventplanner.event.dto.EventInfoUpdateDto;
import org.ivyinc.eventplanner.event.model.EventInfo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EventInfoMapper extends BaseMapper<EventInfo, EventInfoCreateDto, EventInfoUpdateDto, EventInfoResponseDto> {
}
