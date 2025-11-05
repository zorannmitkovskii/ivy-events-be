package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.VendorCreateDto;
import org.ivyinc.eventplanner.event.dto.VendorResponseDto;
import org.ivyinc.eventplanner.event.dto.VendorUpdateDto;
import org.ivyinc.eventplanner.event.model.Vendor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ContactMapper.class, PackageMapper.class})
public interface VendorMapper extends BaseMapper<Vendor, VendorCreateDto, VendorUpdateDto, VendorResponseDto> {
}