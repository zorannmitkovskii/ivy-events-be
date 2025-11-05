package org.ivyinc.eventplanner.common;

import java.util.List;

public interface BaseService<E, CreateReq, UpdateReq, Res> {
    Res create(CreateReq dto);
    Res update(String id, UpdateReq dto);
    void delete(String id);
    Res findById(String id);
    List<Res> findAll();
}
