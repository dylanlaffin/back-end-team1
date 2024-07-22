package org.example.mappers;

import org.example.models.JobRole;
import org.example.models.JobRoleResponse;
import java.util.stream.Collectors;
import java.util.List;

public class JobRoleMapper {

    public static List<JobRoleResponse> mapJobRoleResponseList(
            List<JobRole> jobRoleList) {
        return  jobRoleList
                .stream()
                .map(jobRole -> new JobRoleResponse(jobRole.getJobRoleName(),
                        jobRole.getJobRoleLocation(),
                        jobRole.getJobRoleCapability(),
                        jobRole.getJobRoleBand(),
                        jobRole.getJobRoleClosingDate()))
                .collect(Collectors.toList());
    }

}
