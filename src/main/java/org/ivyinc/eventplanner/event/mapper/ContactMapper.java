package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.ContactCreateDto;
import org.ivyinc.eventplanner.event.dto.ContactResponseDto;
import org.ivyinc.eventplanner.event.dto.ContactUpdateDto;
import org.ivyinc.eventplanner.event.model.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ContactMapper extends BaseMapper<Contact, ContactCreateDto, ContactUpdateDto, ContactResponseDto>{
}