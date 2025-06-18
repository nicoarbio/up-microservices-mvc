package com.nicoarbio.cardealership.vehicle_service.exception.types;

public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}
