package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.BandCreateDto;
import org.ivyinc.eventplanner.event.dto.BandResponseDto;
import org.ivyinc.eventplanner.event.dto.BandUpdateDto;
import org.ivyinc.eventplanner.event.model.Band;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {ContactMapper.class, PackageMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BandMapper extends BaseMapper<Band, BandCreateDto, BandUpdateDto, BandResponseDto>{
}