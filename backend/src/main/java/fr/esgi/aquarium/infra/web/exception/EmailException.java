package fr.esgi.aquarium.infra.web.exception;

import lombok.Getter;

@Getter
public class EmailException extends RuntimeException {
    private final String emailError;

    public EmailException(String emailError) {
        this.emailError = emailError;
    }
}
