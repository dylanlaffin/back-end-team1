package org.example.models;

public class Application {
    String username;
    int applicationID;
    Status status;

    public Application(final String username, final int applicationID,
                       final Status status) {
        this.username = username;
        this.applicationID = applicationID;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(final int applicationID) {
        this.applicationID = applicationID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}
