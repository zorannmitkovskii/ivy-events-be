package org.ivyinc.eventplanner.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseController<E, CreateReq, UpdateReq, Res> {

    BaseService<E, CreateReq, UpdateReq, Res> getService();

    @PostMapping
    default ResponseEntity<Res> create(@RequestBody CreateReq dto) {
        return ResponseEntity.ok(getService().create(dto));
    }

    @PutMapping("/{id}")
    default ResponseEntity<Res> update(@PathVariable String id, @RequestBody UpdateReq dto) {
        return ResponseEntity.ok(getService().update(id, dto));
    }

    @DeleteMapping("/{id}")
    default ResponseEntity<Void> delete(@PathVariable String id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    default ResponseEntity<Res> getById(@PathVariable String id) {
        return ResponseEntity.ok(getService().findById(id));
    }

    @GetMapping
    default ResponseEntity<List<Res>> getAll() {
        return ResponseEntity.ok(getService().findAll());
    }
}
