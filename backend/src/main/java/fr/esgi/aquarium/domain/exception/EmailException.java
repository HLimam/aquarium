package fr.esgi.aquarium.domain.exception;

import lombok.Getter;

@Getter
public class EmailException extends RuntimeException {
    private final String message;

    public EmailException(String message) {
        this.message = message;
    }
}
