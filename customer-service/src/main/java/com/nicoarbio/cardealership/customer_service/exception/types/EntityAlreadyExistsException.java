package com.nicoarbio.cardealership.customer_service.exception.types;

public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}
