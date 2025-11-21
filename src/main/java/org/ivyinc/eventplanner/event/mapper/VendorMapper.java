package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.VendorCreateDto;
import org.ivyinc.eventplanner.event.dto.VendorResponseDto;
import org.ivyinc.eventplanner.event.dto.VendorUpdateDto;
import org.ivyinc.eventplanner.event.model.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {ContactMapper.class, PackageMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface VendorMapper extends BaseMapper<Vendor, VendorCreateDto, VendorUpdateDto, VendorResponseDto> {

    @Override
    @Mappings({
            @Mapping(target = "contact", ignore = true),
            @Mapping(target = "packages", ignore = true)
    })
    Vendor toEntity(VendorCreateDto dto);

    @Override
    @Mappings({
            @Mapping(target = "contact", ignore = true),
            @Mapping(target = "packages", ignore = true)
    })
    void updateEntity(@MappingTarget Vendor entity, VendorUpdateDto dto);
}