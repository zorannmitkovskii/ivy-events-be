package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.VendorCreateDto;
import org.ivyinc.eventplanner.event.dto.VendorResponseDto;
import org.ivyinc.eventplanner.event.dto.VendorUpdateDto;
import org.ivyinc.eventplanner.event.mapper.VendorMapper;
import org.ivyinc.eventplanner.event.model.Vendor;
import org.ivyinc.eventplanner.event.repository.VendorRepository;
import org.springframework.stereotype.Service;


@Service
public class VendorService extends BaseServiceImpl<Vendor, VendorCreateDto, VendorUpdateDto, VendorResponseDto, VendorRepository> {
    public VendorService(VendorRepository repository, VendorMapper mapper) {
        super(repository, mapper);
    }
}
