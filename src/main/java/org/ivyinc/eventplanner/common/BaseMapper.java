package org.ivyinc.eventplanner.common;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseMapper<E, CreateReq, UpdateReq, Res> {
    E toEntity(CreateReq dto);
    Res toResponse(E entity);
    List<Res> toResponses(List<E> entities);
    void updateEntity(@MappingTarget E entity, UpdateReq dto);
}