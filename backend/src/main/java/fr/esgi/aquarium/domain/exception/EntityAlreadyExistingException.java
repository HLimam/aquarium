package fr.esgi.aquarium.domain.exception;

public class EntityAlreadyExistingException extends RuntimeException {
    public EntityAlreadyExistingException() {
        super(ExceptionCode.ENTITY_ALREADY_EXISTING);
    }
}
