package org.ivyinc.eventplanner.event.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
public abstract class BaseService<T extends BaseEntity> {

    protected abstract JpaRepository<T, UUID> getRepository();

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public Optional<T> findById(UUID id) {
        return getRepository().findById(id);
    }

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public void deleteById(UUID id) {
        getRepository().deleteById(id);
    }
}
