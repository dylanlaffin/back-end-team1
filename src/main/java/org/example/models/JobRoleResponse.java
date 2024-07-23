package org.example.models;

import java.sql.Date;

public class JobRoleResponse {
    /*
    instantiates a string of Job Role Name in the Job Role Response
     */
    private String jobRoleName;
    /*
    instantiates a ENUM of Job Role LOCATION in the Job Role Response
     */
    private Locations jobRoleLocation;
    /*
    instantiates a ENUM of Job Role CAPABILITY in the Job Role Response
     */
    private Capability jobRoleCapability;
    /*
    instantiates a ENUM of Job Role BAND in the Job Role Response
     */
    private Band jobRoleBand;
    /*
    instantiates a Date of Job Role CLOSING Date in the Job Role Response
     */
    private Date jobRoleClosingDate;

    public JobRoleResponse(
            final String jRName,
            final Locations jRLocation,
            final Capability jRCapability,
            final Band jRBand,
            final Date jRClosingDate) {
        this.jobRoleName = jRName;
        this.jobRoleLocation = jRLocation;
        this.jobRoleCapability = jRCapability;
        this.jobRoleBand = jRBand;
        this.jobRoleClosingDate = jRClosingDate;
    }

    public String getJobRoleName() {
        return jobRoleName;
    }

    public void setJobRoleName(final String jRName) {
        this.jobRoleName = jRName;
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

