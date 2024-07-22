package org.example.mappers;

import org.example.models.JobRoleResponse;
import java.util.stream.Collectors;
import java.util.List;

public class JobRoleMapper {

    public static List<JobRoleResponse> mapJobRoleResponseList(
            List<JobRoleResponse> jobRoleResponseList) {
        return  jobRoleResponseList
                .stream()
                .map(jobRoleResponse -> new JobRoleResponse(
                        jobRoleResponse.getJobRoleName(),
                        jobRoleResponse.getJobRoleLocation(),
                        jobRoleResponse.getJobRoleCapability(),
                        jobRoleResponse.getJobRoleBand(),
                        jobRoleResponse.getJobRoleClosingDate()))
                .collect(Collectors.toList());
    }

}
