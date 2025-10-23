package org.ivyinc.eventplanner.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class BaseService<T extends BaseEntity> {

    protected abstract JpaRepository<T, Long> getRepository();

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public Optional<T> findById(Long id) {
        return getRepository().findById(id);
    }

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }
}
