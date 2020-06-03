package ua.lviv.lgs.spring.service;

import ua.lviv.lgs.spring.domain.Category;
import ua.lviv.lgs.spring.domain.Type;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Category create(Category category);

    Category update(Category category);

    Optional<Category> findById(Long id);

    void deleteById(Long id);

    List<Category> findByType(Type type);
}
