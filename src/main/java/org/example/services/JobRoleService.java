package org.example.services;

import org.example.daos.JobRoleDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.mappers.JobRoleMapper;
import org.example.models.OpenJobRoleResponse;

import java.sql.SQLException;
import java.util.List;

public class JobRoleService {
    JobRoleDao jobRoleDao;

    public JobRoleService(final JobRoleDao jobRoleDao) {
        this.jobRoleDao = jobRoleDao;
    }

    public List<OpenJobRoleResponse> getOpenJobRoles()
            throws SQLException, DatabaseConnectionException {
        return JobRoleMapper.mapJobRoleResponseList(
                jobRoleDao.getOpenJobRoles());
    }
}
