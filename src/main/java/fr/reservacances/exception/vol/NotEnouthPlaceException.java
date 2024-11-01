package fr.reservacances.exception.vol;

import fr.reservacances.exception.EntityNotFoundException;

public class NotEnouthPlaceException extends RuntimeException {
    public NotEnouthPlaceException() {
        super("Not enough places available");
    }
}
