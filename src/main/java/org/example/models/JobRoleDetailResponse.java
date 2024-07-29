package org.example.models;

import java.sql.Date;

public class JobRoleDetailResponse extends JobRoleResponse{

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


    public JobRoleDetailResponse(
            final int jRID,
            final String jRName,
            final Locations jRLocation,
            final String jRCapability,
            final String jRBand,
            final Date jRClosingDate,
            final String jRSpecUrl,
            final String jRResponsibilities,
            final String jRDescription) {
        super(jRID, jRName, jRLocation, jRCapability, jRBand, jRClosingDate);
        this.jobRoleSpecUrl = jRSpecUrl;
        this.jobRoleResponsibilities = jRResponsibilities;
        this.jobRoleDescription = jRDescription;
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

