package org.ivyinc.eventplanner.event.common;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

/**
 * Generic REST interface providing CRUD endpoints.
 * Implement this interface in entity-specific controllers.
 *
 * Example:
 * @RestController
 * @RequestMapping("/api/events")
 * public class EventController implements BaseController<Event, EventService> { }
 */
public interface BaseController<T extends BaseEntity, S extends BaseService<T>> {

    S getService(); // Implementing class must provide the service

    @GetMapping
    default ResponseEntity<ApiResponse<Page<T>>> findAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "createdAt") String sortBy,
            @RequestParam(required = false, defaultValue = "desc") String direction
    ) {
        Sort sort = "desc".equalsIgnoreCase(direction)
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<T> result = getService().findAll(pageable);
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @GetMapping("/{id}")
    default ResponseEntity<ApiResponse<T>> findById(@PathVariable UUID id) {
        return getService().findById(id)
                .map(entity -> ResponseEntity.ok(ApiResponse.ok(entity)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.fail("Resource not found")));
    }

    @PostMapping
    default ResponseEntity<ApiResponse<T>> create(@Valid @RequestBody T entity) {
        T saved = getService().save(entity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(ApiResponse.ok(saved));
    }

    @PutMapping("/{id}")
    default ResponseEntity<ApiResponse<T>> update(@PathVariable UUID id, @Valid @RequestBody T entity) {
        return getService().findById(id)
                .map(existing -> {
                    entity.setId(id);
                    T updated = getService().save(entity);
                    return ResponseEntity.ok(ApiResponse.ok(updated));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.fail("Resource not found")));
    }

    @DeleteMapping("/{id}")
    default ResponseEntity<Void> delete(@PathVariable UUID id) {
        getService().deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
