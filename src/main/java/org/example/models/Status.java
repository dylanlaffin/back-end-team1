package org.example.models;

public enum Status {
    HIRED("1"),
    REJECTED("2"),
    IN_PROGRESS("3");

    final String status;

    Status(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
