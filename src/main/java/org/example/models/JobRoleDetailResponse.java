package org.example.models;

import java.sql.Date;

public class JobRoleDetailResponse extends JobRoleResponse {


    /*
    instantiates a job role spec Url in the Job Role Response
     */
    private String jobRoleSpecification;


    public JobRoleDetailResponse(
            final int jRID,
            final String jobRoleName,
            final Locations jobRoleLocation,
            final String jobRoleCapability,
            final String jRBand,
            final Date jRClosingDate,
            final String jRSpecification) {
        super(jRID, jobRoleName, jobRoleLocation, jobRoleCapability,
                jRBand, jRClosingDate);
        this.jobRoleSpecification = jRSpecification;
    }

    public String getJobRoleSpecification() {
        return jobRoleSpecification;
    }

    public void setJobRoleSpecification(final String jobRoleSpecification) {
        this.jobRoleSpecification = jobRoleSpecification;
    }


}

