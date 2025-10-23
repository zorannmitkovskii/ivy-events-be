package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.ApiResponse;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.LocationUpdateDto;
import org.ivyinc.eventplanner.event.enums.LocationType;
import org.ivyinc.eventplanner.event.model.Location;
import org.ivyinc.eventplanner.event.service.LocationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/locations")
public class LocationController implements BaseController<Location, LocationService> {

    private final LocationService locationService;

    @Override
    public LocationService getService() {
        return locationService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<Location>>> getAll(Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(locationService.findAll(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Location>>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(locationService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Location>> create(@RequestBody Location location) {
        return ResponseEntity.ok(ApiResponse.ok(locationService.save(location)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Location>> update(@PathVariable Long id, @RequestBody LocationUpdateDto updatedDto) {
        return ResponseEntity.ok(ApiResponse.ok(locationService.update(id, updatedDto)));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<ApiResponse<Page<Location>>> getByType(@PathVariable LocationType type, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(locationService.findByType(type, pageable)));
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<ApiResponse<Page<Location>>> getByCity(@PathVariable String city, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(locationService.findByCity(city, pageable)));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Page<Location>>> search(@RequestParam String keyword, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(locationService.search(keyword, pageable)));
    }
}