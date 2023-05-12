package ru.practicum.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.practicum.category.model.Category;

@Repository(value = "dbCategoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findFirstByName(String name);

    @Query(value = "SELECT * " +
            "FROM categories AS c " +
            "WHERE c.category_id = ?1 " +
            "LIMIT 1", nativeQuery = true)
    Category findCategoryById(Long catId);

}