package fr.esgi.aquarium.domain.exception;

import lombok.Getter;

@Getter
public class PasswordConfirmationException extends RuntimeException {
    private final String message;

    public PasswordConfirmationException(String message) {
        this.message = message;
    }
}
