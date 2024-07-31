package org.example.models;

import java.sql.Date;

public class JobRoleDetailResponse extends JobRoleResponse {

    /*
    instantiates a job role specification,
    this includes the job role description,
    the job role responsibilities,
    and the job role spec URL
    in the jobRoleDetailResponse
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

