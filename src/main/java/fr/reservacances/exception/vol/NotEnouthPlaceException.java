package fr.reservacances.exception.vol;

public class NotEnouthPlaceException extends RuntimeException {
    public NotEnouthPlaceException() {
        super("Not enough places available");
    }
}
