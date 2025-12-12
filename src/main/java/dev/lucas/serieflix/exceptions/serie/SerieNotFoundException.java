package dev.lucas.serieflix.exceptions.serie;

public class SerieNotFoundException extends RuntimeException {
    public SerieNotFoundException(long id) {
        super("The serie with id: " + id + " not found.");
    }

}
