package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationRequest {
    int applicationID;
    Status status;

    @JsonCreator
    public ApplicationRequest(@JsonProperty(
            "applicationID") final int applicationID,
                              @JsonProperty("status") final Status status) {
        this.applicationID = applicationID;
        this.status = status;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(final int applicationID) {
        this.applicationID = applicationID;
    }

    public String getStatus() {
        return status.getStatus();
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}
