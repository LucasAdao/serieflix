package dev.lucas.serieflix.mapper;

import dev.lucas.serieflix.controller.request.CategoryRequest;
import dev.lucas.serieflix.controller.response.CategoryResponse;
import dev.lucas.serieflix.model.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category  toCategory(CategoryRequest request){
        return Category
                .builder()
                .name(request.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category prepareToUpdate(Category category, CategoryRequest request){
        if (request == null || category == null) {
            return category;
        }
        if(request.name() != null){
            category.setName(request.name());
        }
        return category;
    }
}
