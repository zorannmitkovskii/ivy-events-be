package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.InvitationSectionCreateDto;
import org.ivyinc.eventplanner.event.dto.InvitationSectionResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationSectionUpdateDto;
import org.ivyinc.eventplanner.event.model.InvitationSection;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface InvitationSectionMapper extends BaseMapper<InvitationSection, InvitationSectionCreateDto, InvitationSectionUpdateDto, InvitationSectionResponseDto>{
}