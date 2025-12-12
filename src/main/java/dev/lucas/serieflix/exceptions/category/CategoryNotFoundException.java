package dev.lucas.serieflix.exceptions.category;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(long id) {
        super("The category with id: " + id + " not found.");
    }
}
