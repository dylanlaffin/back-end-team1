package org.example.models;

import java.sql.Date;

public class JobRoleResponse {
    private String jobRoleName;
    private Locations jobRoleLocation;
    private Capability jobRoleCapability;
    private Band jobRoleBand;
    private Date jobRoleClosingDate;

    public JobRoleResponse(
            final String jobRoleName,
            final Locations jobRoleLocation,
            final Capability jobRoleCapability,
            final Band jobRoleBand,
            final Date jobRoleClosingDate) {
        this.jobRoleName = jobRoleName;
        this.jobRoleLocation = jobRoleLocation;
        this.jobRoleCapability = jobRoleCapability;
        this.jobRoleBand = jobRoleBand;
        this.jobRoleClosingDate = jobRoleClosingDate;
    }

    public String getJobRoleName() {
        return jobRoleName;
    }

    public void setJobRoleName(final String jobRoleName) {
        this.jobRoleName = jobRoleName;
    }

    public Locations getJobRoleLocation() {
        return jobRoleLocation;
    }

    public void setJobRoleLocation(final Locations jobRoleLocation) {
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

