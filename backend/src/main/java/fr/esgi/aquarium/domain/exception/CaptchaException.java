package fr.esgi.aquarium.domain.exception;

import lombok.Getter;

@Getter
public class CaptchaException extends RuntimeException {
    private final String message;

    public CaptchaException(String message) {
        this.message = message;
    }
}
