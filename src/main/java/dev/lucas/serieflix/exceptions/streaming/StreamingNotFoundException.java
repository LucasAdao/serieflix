package dev.lucas.serieflix.exceptions.streaming;

public class StreamingNotFoundException extends RuntimeException{

    public StreamingNotFoundException(long id) {
        super("The streaming with id: " + id + " not found.");
    }
}
