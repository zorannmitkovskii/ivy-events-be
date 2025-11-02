package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.PackageCreateDto;
import org.ivyinc.eventplanner.event.dto.PackageResponseDto;
import org.ivyinc.eventplanner.event.dto.PackageUpdateDto;
import org.ivyinc.eventplanner.event.model.Package;
import org.ivyinc.eventplanner.event.service.PackageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/packages")
public class PackageController implements BaseController<Package, PackageCreateDto, PackageUpdateDto, PackageResponseDto> {

    private final PackageService packageService;

    @Override
    public PackageService getService() {
        return packageService;
    }
}
