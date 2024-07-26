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
    private String jobRoleCapability;
    /*
    instantiates a ENUM of Job Role BAND in the Job Role Response
     */
    private String jobRoleBand;
    /*
    instantiates a Job Role CLOSING Date in the Job Role Response
     */
    private Date jobRoleClosingDate;
    /*
    instantiates a job role spec Url in the Job Role Response
     */
    private String jobRoleSpecUrl;
    /*
    instantiates a job roles responsibilities in the Job Role Response
     */
    private String jobRoleResponsibilities;
    /*
    instantiates a Date of Job Role Description Date in the Job Role Response
     */
    private String jobRoleDescription;


    public JobRoleResponse(
            final String jRName,
            final Locations jRLocation,
            final String jRCapability,
            final String jRBand,
            final Date jRClosingDate,
            final String jRSpecUrl,
            final String jRResponsibilities,
            final String jRDescription) {
        this.jobRoleName = jRName;
        this.jobRoleLocation = jRLocation;
        this.jobRoleCapability = jRCapability;
        this.jobRoleBand = jRBand;
        this.jobRoleClosingDate = jRClosingDate;
        this.jobRoleSpecUrl = jRSpecUrl;
        this.jobRoleResponsibilities = jRResponsibilities;
        this.jobRoleDescription = jRDescription;
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

    public String getJobRoleCapability() {
        return jobRoleCapability;
    }

    public void setJobRoleCapability(final String jobRoleCapability) {
        this.jobRoleCapability = jobRoleCapability;
    }

    public String getJobRoleBand() {
        return jobRoleBand;
    }

    public void setJobRoleBand(final String jobRoleBand) {
        this.jobRoleBand = jobRoleBand;
    }

    public Date getJobRoleClosingDate() {
        return jobRoleClosingDate;
    }

    public void setJobRoleClosingDate(final Date jobRoleClosingDate) {
        this.jobRoleClosingDate = jobRoleClosingDate;
    }

    public String getJobRoleSpecUrl() {
        return jobRoleSpecUrl;
    }

    public void setJobRoleSpecUrl(final String jobRoleSpecUrl) {
        this.jobRoleSpecUrl = jobRoleSpecUrl;
    }

    public String getJobRoleResponsibilities() {
        return jobRoleResponsibilities;
    }

    public void setJobRoleResponsibilities(final String jobRoleResponsibilities) {
        this.jobRoleResponsibilities = jobRoleResponsibilities;
    }

    public String getJobRoleDescription() {
        return jobRoleDescription;
    }

    public void setJobRoleDescription(final String jobRoleDescription) {
        this.jobRoleDescription = jobRoleDescription;
    }
}

