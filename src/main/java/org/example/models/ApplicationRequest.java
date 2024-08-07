package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationRequest {
    String username;
    String status;
    String applicationURL;

    @JsonCreator
    public ApplicationRequest(
            @JsonProperty("username") final String username,
            @JsonProperty("status") final String status,
            @JsonProperty("applicationURL") final String applicationURL) {
        this.username = username;
        this.status = status;
        this.applicationURL = applicationURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }


    public String getApplicationURL() {
        return applicationURL;
    }

}
