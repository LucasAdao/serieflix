package dev.lucas.serieflix.exceptions.category;

public class CategoryNotNullException extends RuntimeException {
    public CategoryNotNullException() {
        super("You cannot enter a null category..");
    }
}
