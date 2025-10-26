package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.Package;
import org.ivyinc.eventplanner.event.repository.PackageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PackageService extends BaseService<Package> {

    private final PackageRepository packageRepository;

    @Override
    protected JpaRepository<Package, Long> getRepository() {
        return packageRepository;
    }

    public Page<Package> findByVendorId(Long vendorId, Pageable pageable) {
        return packageRepository.findByVendorId(vendorId, pageable);
    }
}
