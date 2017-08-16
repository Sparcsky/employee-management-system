package com.sparcsky.ems;

import java.util.List;

public interface BaseDao<T> {


    T find(String ID, String password);

    List<T> find();

    void insert(T value);

    void update(T value);

    void delete(T value);
}
