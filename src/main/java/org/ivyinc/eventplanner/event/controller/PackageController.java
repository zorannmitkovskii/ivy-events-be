package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.ApiResponse;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.model.Package;
import org.ivyinc.eventplanner.event.service.PackageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/packages")
public class PackageController implements BaseController<Package, PackageService> {

    private final PackageService packageService;

    @Override
    public PackageService getService() {
        return packageService;
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<ApiResponse<Page<Package>>> getByVendor(@PathVariable Long vendorId, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(packageService.findByVendorId(vendorId, pageable)));
    }
}
