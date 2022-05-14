package fr.esgi.aquarium.domain.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
        super(ExceptionCode.ENTITY_NOT_FOUND);
    }
}
