package ru.practicum.category.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.practicum.ApiError.exception.BadRequestException;
import ru.practicum.ApiError.exception.NotFoundException;
import ru.practicum.category.dto.CategoryDto;
import ru.practicum.category.model.Category;
import ru.practicum.category.model.CategoryMapper;
import ru.practicum.category.repository.CategoryRepository;
import ru.practicum.category.service.CategoryService;

@Component
@RequiredArgsConstructor
@Slf4j
public class CategoryUtils {

    private final CategoryRepository categoryRepository;

    public Category getCategoryModelById(Long catId) {
        log.info("Получение категории по ID = {}.", catId);
        return categoryRepository.findById(catId).orElseThrow(
                () -> new NotFoundException("Категория с ID = " + catId + " не найдена."));
    }

    public CategoryDto getCategoryById(Long catId) {
        log.info("Получение категории по ID = {}.", catId);
        return CategoryMapper.INSTANT.toCategoryDto(categoryRepository.findById(catId).orElseThrow(
                () -> new NotFoundException("Категория с ID = " + catId + " не найдена.")
        ));
    }

    public void isCategoryPresent(Long catId) {
        if (categoryRepository.getCategoryById(catId) == null) {
            log.error("Категория c ID = {} не существует.",catId);
            throw new BadRequestException("Категория c ID = " + catId + " не существует.");
        }
    }
}
