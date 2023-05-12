package ru.practicum.category.service;

import ru.practicum.category.dto.CategoryDto;
import ru.practicum.category.dto.NewCategoryDto;

public interface CategoryService {

    CategoryDto createCategory(NewCategoryDto newCategory);

    CategoryDto patchCategoryById(Long catId, NewCategoryDto updateCategory);

    void deleteCategory(Long catId);

    CategoryDto getCategoryById(Long catId);

    void isCategoryNameIsBusy(String name);

    void isCategoryPresent(Long catId);

    void isCategoryUsing(Long catId);


}
