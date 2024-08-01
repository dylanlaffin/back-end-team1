package org.example.Exceptions;

public class DoesNotExistException extends Throwable {

    public DoesNotExistException(final ErrorEntity errorEntity) {
        super(errorEntity.getEntity() + " does not exist");
    }
}
