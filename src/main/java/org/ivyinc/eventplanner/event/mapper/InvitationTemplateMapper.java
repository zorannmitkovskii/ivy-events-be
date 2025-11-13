package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.InvitationTemplateCreateRequestDto;
import org.ivyinc.eventplanner.event.dto.InvitationTemplateResponseDto;
import org.ivyinc.eventplanner.event.dto.InvitationTemplateUpdateRequestDto;
import org.ivyinc.eventplanner.event.model.InvitationTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface InvitationTemplateMapper extends BaseMapper<InvitationTemplate, InvitationTemplateCreateRequestDto, InvitationTemplateUpdateRequestDto, InvitationTemplateResponseDto>{
}