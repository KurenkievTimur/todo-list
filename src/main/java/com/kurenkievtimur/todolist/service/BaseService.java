package com.kurenkievtimur.todolist.service;

import com.kurenkievtimur.todolist.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity, ID> {
    List<T> getAll();

    Optional<T> getById(ID id);

    T saveOrUpdate(T entity);

    void delete(T entity);
}
