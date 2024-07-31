package org.example.models;

import java.sql.Date;

public class JobRoleDetailResponse extends JobRoleResponse {

    /*
    instantiates a job role spec Url in the Job Role Response
     */
    private JobRoleSpecification jobRoleSpecification;

    public JobRoleDetailResponse(
            final int jRID,
            final String jobRoleName,
            final Locations jobRoleLocation,
            final String jobRoleCapability,
            final String jRBand,
            final Date jRClosingDate,
            final JobRoleSpecification jRSpecification) {
        super(jRID, jobRoleName, jobRoleLocation, jobRoleCapability,
                jRBand, jRClosingDate);
        this.jobRoleSpecification = jRSpecification;
    }

    public JobRoleSpecification getJobRoleSpecification() {
        return jobRoleSpecification;
    }

    public void setJobRoleSpecification(
            final JobRoleSpecification jobRoleSpecification) {
        this.jobRoleSpecification = jobRoleSpecification;
    }

}

