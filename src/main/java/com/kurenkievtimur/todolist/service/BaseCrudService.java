package com.kurenkievtimur.todolist.service;

import com.kurenkievtimur.todolist.entity.BaseEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class BaseCrudService<T extends BaseEntity, ID> implements BaseService<T, ID> {
    protected final ListCrudRepository<T, ID> repository;

    protected BaseCrudService(ListCrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<T> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<T> getById(ID id) {
        return repository.findById(id);
    }

    @Transactional
    public T saveOrUpdate(T entity) {
        return repository.save(entity);
    }

    @Transactional
    public void delete(T entity) {
        repository.delete(entity);
    }
}
