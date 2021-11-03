package ru.rudko.dao;

import java.util.List;

public interface DAO<T> {
    void add(T t);
    T getById(int id);
    void update(T t);
    void delete(T t);
    List<T> getAll();
}