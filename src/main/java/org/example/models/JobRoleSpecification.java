package org.example.models;

public class JobRoleSpecification {
    private String jobRoleSpecUrl;

    private String jobRoleResponsibilities;

    private String jobRoleDescription;

    public JobRoleSpecification(
            final String jobRoleSpecUrl,
            final String jobRoleResponsibilities,
            final String jobRoleDescription) {
        this.jobRoleSpecUrl = jobRoleSpecUrl;
        this.jobRoleResponsibilities = jobRoleResponsibilities;
        this.jobRoleDescription = jobRoleDescription;
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

    public void setJobRoleResponsibilities(
            final String jobRoleResponsibilities) {
        this.jobRoleResponsibilities = jobRoleResponsibilities;
    }

    public String getJobRoleDescription() {
        return jobRoleDescription;
    }

    public void setJobRoleDescription(final String jobRoleDescription) {
        this.jobRoleDescription = jobRoleDescription;
    }
}
