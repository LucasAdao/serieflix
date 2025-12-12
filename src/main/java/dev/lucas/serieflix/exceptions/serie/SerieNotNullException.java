package dev.lucas.serieflix.exceptions.serie;

public class SerieNotNullException extends RuntimeException {
    public SerieNotNullException() {
        super("You cannot enter a null serie..");
    }
}
