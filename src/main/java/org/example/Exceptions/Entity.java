package org.example.Exceptions;

public enum Entity {
    JOBROLERESPONSE("JobRole"),
    JOBROLEDETAILRESPONSE("JobRoleDetailResponse");

    private final String entity;
    Entity(final String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return this.entity;
    }
}
