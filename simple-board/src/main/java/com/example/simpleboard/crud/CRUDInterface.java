package com.example.simpleboard.crud;

import com.example.simpleboard.common.Api;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface CRUDInterface<T> {
    T create(T dto);

    Optional<T> read(Long id);

    T update(T t);

    void delete(Long id);

    Api<List<T>> List(Pageable pageable);

}
