package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.PackageCreateDto;
import org.ivyinc.eventplanner.event.dto.PackageResponseDto;
import org.ivyinc.eventplanner.event.dto.PackageUpdateDto;
import org.ivyinc.eventplanner.event.mapper.PackageMapper;
import org.ivyinc.eventplanner.event.model.Package;
import org.ivyinc.eventplanner.event.repository.PackageRepository;
import org.springframework.stereotype.Service;


@Service
public class PackageService extends BaseServiceImpl<Package, PackageCreateDto, PackageUpdateDto, PackageResponseDto, PackageRepository> {
    public PackageService(PackageRepository repository, PackageMapper mapper) {
        super(repository, mapper);
    }
}
