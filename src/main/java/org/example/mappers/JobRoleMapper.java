package org.example.mappers;

import org.example.models.JobRoleResponse;
import java.util.stream.Collectors;
import java.util.List;

public class JobRoleMapper {
   private JobRoleMapper jobRoleMapper;
    /*
    maps the JobRoleResponse to a stream
    and then uses Collectors to convert the stream to a List
     */
    public static List<JobRoleResponse> mapJobRoleResponseList(
            final List<JobRoleResponse> jobRoleResponseList) {
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
