package com.sparcsky.ems.model;

import java.util.List;

public interface BaseDao<T> {


    T find(String ID, String password);

    List<T> getList();

    void insert(T value);

    void update(T value);

    void delete(T value);
}
