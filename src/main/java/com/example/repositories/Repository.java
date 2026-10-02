package com.example.repositories;

import java.util.List;

public interface Repository<T, ID> {
    public List<T> findAll();
    public T save(T t);
    public T update(T t);
    public int delete(ID id);
}
