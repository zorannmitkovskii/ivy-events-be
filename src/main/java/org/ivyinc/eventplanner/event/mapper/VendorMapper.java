package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.*;
import org.ivyinc.eventplanner.event.model.Vendor;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ContactMapper.class, PackageMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface VendorMapper extends BaseMapper<Vendor, VendorCreateDto, VendorUpdateDto, VendorResponseDto> {
}