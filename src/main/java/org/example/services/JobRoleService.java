package org.example.services;

import org.example.Exceptions.DoesNotExistException;
import org.example.Exceptions.ErrorEntity;
import org.example.daos.JobRoleDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRoleDetailResponse;
import org.example.models.JobRoleResponse;

import java.sql.SQLException;
import java.util.List;

public class JobRoleService {
    JobRoleDao jobRoleDao;

    public JobRoleService(final JobRoleDao jobRoleDao) {
        this.jobRoleDao = jobRoleDao;
    }

    public List<JobRoleResponse> getOpenJobRoles()
            throws SQLException, DatabaseConnectionException {
        return jobRoleDao.getOpenJobRoles();
    }

    public JobRoleDetailResponse getJobRoleById(final int id)
            throws SQLException, DatabaseConnectionException,
            DoesNotExistException {
        JobRoleDetailResponse jobRoleDetailResponse
                = jobRoleDao.getJobRoleByID(id);
        if (jobRoleDetailResponse == null) {
            throw new DoesNotExistException(ErrorEntity.JRDETAILRESPONSE);
        }
        return jobRoleDetailResponse;
    }

    public List<JobRoleResponse> jobNameAscending()
            throws SQLException, DatabaseConnectionException {
        return jobRoleDao.jobNameAscending();
    }

}
