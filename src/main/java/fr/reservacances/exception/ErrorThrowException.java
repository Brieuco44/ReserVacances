package fr.reservacances.exception;

public class ErrorThrowException extends RuntimeException {
    public ErrorThrowException() {
        super("Une erreur est survenue");
    }
}
