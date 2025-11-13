package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.InvitationCreateDto;
import org.ivyinc.eventplanner.event.dto.InvitationResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationUpdateDto;
import org.ivyinc.eventplanner.event.model.Invitation;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface InvitationMapper extends BaseMapper<Invitation, InvitationCreateDto, InvitationUpdateDto, InvitationResponseDto>{
}