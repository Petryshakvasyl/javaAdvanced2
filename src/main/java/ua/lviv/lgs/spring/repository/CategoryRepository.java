package ua.lviv.lgs.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.spring.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
