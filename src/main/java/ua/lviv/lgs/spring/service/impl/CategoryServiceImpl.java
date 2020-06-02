package ua.lviv.lgs.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.spring.domain.Category;
import ua.lviv.lgs.spring.error.ResourceNotFoundException;
import ua.lviv.lgs.spring.repository.CategoryRepository;
import ua.lviv.lgs.spring.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        log.debug("find all categories");
        return categoryRepository.findAll();
    }

    @Override
    public Category create(Category category) {
        log.debug("create category {}", category);
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category categoryToUpdate) {
        log.debug("update category {}", categoryToUpdate);
        if (categoryToUpdate.getId() == null) {
            //todo implement this
            log.error("update category without id");
        }
        Category currentCategory = categoryRepository.findById(categoryToUpdate.getId())
                .orElseThrow(() -> new ResourceNotFoundException(categoryToUpdate.getId()));
        currentCategory.setName(categoryToUpdate.getName());
        currentCategory.setType(categoryToUpdate.getType());

        return categoryRepository.save(currentCategory);
    }

    @Override
    public Optional<Category> findById(Long id) {
        log.debug("find category by id {}", id);
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("delete category by id {}", id);
        categoryRepository.deleteById(id);
    }
}
