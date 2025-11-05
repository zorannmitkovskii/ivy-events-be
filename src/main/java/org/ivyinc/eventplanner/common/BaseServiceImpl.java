package org.ivyinc.eventplanner.common;

import java.util.List;
import java.util.UUID;

public class BaseServiceImpl<E extends BaseEntity, CreateReq, UpdateReq, Res, R extends BaseRepository<E>>
        implements BaseService<E, CreateReq, UpdateReq, Res>{
    protected final R repository;
    protected final BaseMapper<E, CreateReq, UpdateReq, Res> mapper;

    public BaseServiceImpl(R repository, BaseMapper<E, CreateReq, UpdateReq, Res> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Res create(CreateReq dto) {
        return mapper.toResponse(
                repository.save(mapper.toEntity(dto))
        );
    }

    @Override
    public Res update(String id, UpdateReq dto) {
        E entity = repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
        mapper.updateEntity(entity, dto);
        E saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(UUID.fromString(id));
    }

    @Override
    public Res findById(String id) {
        return mapper.toResponse(repository.findById(UUID.fromString(id)).orElse(null));
    }

    @Override
    public List<Res> findAll() {
        return mapper.toResponses(repository.findAll());
    }
}
