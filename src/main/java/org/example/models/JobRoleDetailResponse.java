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

    @SuppressWarnings("checkstyle:ParameterNumber")
    public JobRoleDetailResponse(
            final int jRID,
            final String jobRoleName,
            final Locations jobRoleLocation,
            final String jobRoleCapability,
            final String jRBand,
            final Date jRClosingDate,
            final JobRoleSpecification jRSpecification,
            final int numOpenPos) {
        super(jRID, jobRoleName, jobRoleLocation, jobRoleCapability,
                jRBand, jRClosingDate, numOpenPos);
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

