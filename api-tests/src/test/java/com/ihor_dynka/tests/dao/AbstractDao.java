package com.ihor_dynka.tests.dao;

import java.util.List;

public interface AbstractDao<E, K> {

    List<E> getAll();

    E update(E entity);
}
