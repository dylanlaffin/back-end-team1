package org.example.Exceptions;

public enum Entity {
    ADMIN("Admin"),
    USER("User");

    private final String entity;

    Entity(final String ent) {
        this.entity = ent;
    }

    /**
     * Get the entity value.
     * @return the value corresponding to the
     * entity enum value.
     */
    public String getEntity() {
        return this.entity;
    }
}
