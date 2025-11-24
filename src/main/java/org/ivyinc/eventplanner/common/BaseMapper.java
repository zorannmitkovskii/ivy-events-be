package org.ivyinc.eventplanner.common;

import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.UUID;

public interface BaseMapper<E, CreateReq, UpdateReq, Res> {
    E toEntity(CreateReq dto);
    Res toResponse(E entity);
    List<Res> toResponses(List<E> entities);
    void updateEntity(@MappingTarget E entity, UpdateReq dto);

    /**
     * Generic helper for mapping UUID to an entity reference.
     * Used to set only the ID on associations (ManyToOne, etc.)
     */
    default <T> T mapReference(UUID id, Class<T> type) {
        if (id == null) return null;
        try {
            T entity = type.getDeclaredConstructor().newInstance();
            var idField = type.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(entity, id);
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Failed to map UUID to " + type.getName(), e);
        }
    }
}