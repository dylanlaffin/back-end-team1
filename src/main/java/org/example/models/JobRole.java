package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class JobRole {
    @JsonProperty
    private int jobRoleID;
    @JsonProperty
    private String jobRoleName;
    @JsonProperty
    private Location jobRoleLocation;
    @JsonProperty
    private Capability jobRoleCapability;
    @JsonProperty
    private Band jobRoleBand;
    @JsonProperty
    private Date jobRoleClosingDate;

    public JobRole(
            final int jobRoleID,
            final String jobRoleName,
            final Location jobRoleLocation,
            final Capability jobRoleCapability,
            final Band jobRoleBand,
            final Date jobRoleClosingDate) {
        this.jobRoleID = jobRoleID;
        this.jobRoleName = jobRoleName;
        this.jobRoleLocation = jobRoleLocation;
        this.jobRoleCapability = jobRoleCapability;
        this.jobRoleBand = jobRoleBand;
        this.jobRoleClosingDate = jobRoleClosingDate;
    }

    public int getJobRoleID() {
        return jobRoleID;
    }

    public void setJobRoleID(final int jobRoleID) {
        this.jobRoleID = jobRoleID;
    }

    public String getJobRoleName() {
        return jobRoleName;
    }

    public void setJobRoleName(final String jobRoleName) {
        this.jobRoleName = jobRoleName;
    }

    public Location getJobRoleLocation() {
        return jobRoleLocation;
    }

    public void setJobRoleLocation(final Location jobRoleLocation) {
        this.jobRoleLocation = jobRoleLocation;
    }

    public Capability getJobRoleCapability() {
        return jobRoleCapability;
    }

    public void setJobRoleCapability(final Capability jobRoleCapability) {
        this.jobRoleCapability = jobRoleCapability;
    }

    public Band getJobRoleBand() {
        return jobRoleBand;
    }

    public void setJobRoleBand(final Band jobRoleBand) {
        this.jobRoleBand = jobRoleBand;
    }

    public Date getJobRoleClosingDate() {
        return jobRoleClosingDate;
    }

    public void setJobRoleClosingDate(final Date jobRoleClosingDate) {
        this.jobRoleClosingDate = jobRoleClosingDate;
    }
}
