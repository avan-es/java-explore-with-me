package ru.practicum.category.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.ApiError.exception.BadRequestException;
import ru.practicum.ApiError.exception.NotFoundException;
import ru.practicum.category.dto.CategoryDto;
import ru.practicum.category.dto.NewCategoryDto;
import ru.practicum.category.model.Category;
import ru.practicum.category.model.CategoryMapper;
import ru.practicum.category.repository.CategoryRepository;
import ru.practicum.event.repository.EventRepository;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final EventRepository eventRepository;

    @Override
    @Transactional
    public CategoryDto createCategory(NewCategoryDto newCategory) {
        log.info("Создание новой категории: {}.", newCategory.getName());
        isCategoryNameIsBusy(newCategory.getName());
        Category category = categoryRepository.save(
                CategoryMapper.INSTANT.newCategoryDtoToCategory(newCategory));
        log.debug("Категория создана. ID = {}.", category.getId());
        return CategoryMapper.INSTANT.toCategoryDto(category);
    }

    @Override
    public CategoryDto getCategoryById(Long catId) {
        log.info("Получение категории по ID = {}.", catId);
        return CategoryMapper.INSTANT.toCategoryDto(categoryRepository.findById(catId).orElseThrow(
                () -> new NotFoundException("Категория с ID = " + catId + " не найдена.")
        ));
    }

    @Override
    @Transactional
    public CategoryDto patchCategoryById(Long catId, NewCategoryDto updatedCategory) {
        log.info("Обновление категории с ID = {}.", catId);
        isCategoryNameIsBusy(updatedCategory.getName());
        isCategoryPresent(catId);
        Category category = categoryRepository.findCategoryById(catId);
        category.setName(updatedCategory.getName());
        categoryRepository.save(category);
        log.debug("Категория с ID = {} обновлена.", catId);
        return CategoryMapper.INSTANT.toCategoryDto(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Long catId) {
        log.info("Удаление категории с ID = {}.", catId);
        isCategoryPresent(catId);
        isCategoryUsing(catId);
        categoryRepository.deleteById(catId);
        log.debug("Категории с ID = {} удалена.", catId);
    }

    @Override
    public void isCategoryNameIsBusy(String name) {
        if (categoryRepository.findFirstByName(name) != null) {
            log.error("Категория \"{}\" уже существует.",name);
            throw new BadRequestException("Категория уже существует.");
        };
    }

    @Override
    public void isCategoryPresent(Long catId) {
        if (categoryRepository.findCategoryById(catId) == null) {
            log.error("Категория c ID = {} не существует.",catId);
            throw new BadRequestException("Категория c ID = " + catId + " не существует.");
        };
    }

    @Override
    public void isCategoryUsing(Long catId) {
        if (eventRepository.findFirstByCategory(catId) != null) {
            log.error("Категория c ID = {} используется и не может быть удалена.",catId);
            throw new BadRequestException("Категория c ID = " + catId + " используется и не может быть удалена.");
        };
    }
}
