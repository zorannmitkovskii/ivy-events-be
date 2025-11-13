package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.FormFieldCreateDto;
import org.ivyinc.eventplanner.event.dto.FormFieldResponseDto;
import org.ivyinc.eventplanner.event.dto.FormFieldUpdateDto;
import org.ivyinc.eventplanner.event.model.FormField;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FormFieldMapper extends BaseMapper<FormField, FormFieldCreateDto, FormFieldUpdateDto, FormFieldResponseDto>{
}