package org.ivyinc.eventplanner.event.service;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseService;
import org.ivyinc.eventplanner.event.model.Vendor;
import org.ivyinc.eventplanner.event.repository.VendorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorService extends BaseService<Vendor> {

    private final VendorRepository vendorRepository;

    @Override
    protected JpaRepository<Vendor, Long> getRepository() {
        return vendorRepository;
    }
}
