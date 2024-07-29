package org.example.Exceptions;

public enum Entity {
    JOBROLERESPONSE("JobRole"),
    OPENJOBROLERESPONSE("OpenJobRole");

    private final String entity;
    Entity(String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return this.entity;
    }
}
