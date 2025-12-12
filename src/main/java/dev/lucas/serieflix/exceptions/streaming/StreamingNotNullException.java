package dev.lucas.serieflix.exceptions.streaming;

public class StreamingNotNullException extends RuntimeException {
    public StreamingNotNullException() {
        super("You cannot enter a null streaming..");
    }
}
