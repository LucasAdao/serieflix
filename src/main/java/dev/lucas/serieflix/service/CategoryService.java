package dev.lucas.serieflix.service;

import dev.lucas.serieflix.controller.request.CategoryRequest;
import dev.lucas.serieflix.controller.response.CategoryResponse;
import dev.lucas.serieflix.exceptions.category.CategoryNotFoundException;
import dev.lucas.serieflix.exceptions.category.CategoryNotNullException;
import dev.lucas.serieflix.mapper.CategoryMapper;
import dev.lucas.serieflix.model.Category;
import dev.lucas.serieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryResponse findById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.map(CategoryMapper::toCategoryResponse).orElseThrow(() -> new CategoryNotFoundException(id));

    }

    public List<CategoryResponse> findAll() {
        List<Category> categories = repository.findAll();
        return categories.stream()
                .map(CategoryMapper::toCategoryResponse)
                .collect(Collectors.toList());
    }

    public CategoryResponse save(CategoryRequest request) {
        if(request == null) {
            throw new CategoryNotNullException();
        }
        Category category = CategoryMapper.toCategory(request);
        category = repository.save(category);
        return CategoryMapper.toCategoryResponse(category);
    }

    public void deleteById(Long id) {
        repository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        repository.deleteById(id);
    }

    public CategoryResponse updateById(Long id, CategoryRequest request) {
        Category category = repository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        Category categoryToSave = CategoryMapper.prepareToUpdate(category,request);
        repository.save(categoryToSave);
        return CategoryMapper.toCategoryResponse(categoryToSave);
    }

}
