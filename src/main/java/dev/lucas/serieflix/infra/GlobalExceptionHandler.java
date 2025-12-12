package dev.lucas.serieflix.infra;

import dev.lucas.serieflix.exceptions.category.CategoryNotFoundException;
import dev.lucas.serieflix.exceptions.category.CategoryNotNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ CategoryNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail handleCategoryNotFoundException(CategoryNotFoundException e) {
        var pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        pd.setTitle("Category Not Found");
        pd.setType(URI.create("https:/www.awesomeurl.com/erros/not-found"));
        return pd;
    }

    @ExceptionHandler({CategoryNotNullException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleCategoryNotNullException(CategoryNotNullException e) {
        var pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        pd.setTitle("Category Not Found");
        pd.setType(URI.create("https:/www.awesomeurl.com/erros/bad-request"));
        return pd;
    }
}
