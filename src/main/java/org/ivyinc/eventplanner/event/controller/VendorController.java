package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.VendorCreateDto;
import org.ivyinc.eventplanner.event.dto.VendorResponseDto;
import org.ivyinc.eventplanner.event.dto.VendorUpdateDto;
import org.ivyinc.eventplanner.event.model.Vendor;
import org.ivyinc.eventplanner.event.service.VendorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/vendors")
public class VendorController implements BaseController<Vendor, VendorCreateDto, VendorUpdateDto, VendorResponseDto> {

    private final VendorService vendorService;

    @Override
    public VendorService getService() {
        return vendorService;
    }
}