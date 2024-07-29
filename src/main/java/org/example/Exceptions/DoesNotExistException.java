package org.example.Exceptions;

public class DoesNotExistException extends Throwable {

    public DoesNotExistException(Entity entity) {
        super (entity.getEntity() + " does not exist" );
    }
}
