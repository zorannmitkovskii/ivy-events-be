package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.PackageCreateDto;
import org.ivyinc.eventplanner.event.dto.PackageResponseDto;
import org.ivyinc.eventplanner.event.dto.PackageUpdateDto;
import org.ivyinc.eventplanner.event.model.Package;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PackageMapper extends BaseMapper<Package, PackageCreateDto, PackageUpdateDto, PackageResponseDto>{
}