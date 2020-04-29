package ua.lviv.lgs.pv.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, E> {

    void save(T t);

    void update(T t);

    List<T> findAll();

    Optional<T> findById(E e);

    void deleteById(E e);

}
