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

    public List<JobRoleResponse> jobNameDescending()
            throws SQLException, DatabaseConnectionException {
        return jobRoleDao.jobNameDescending();
    }

    public List<JobRoleResponse> jobLocationAscending()
            throws SQLException, DatabaseConnectionException {
        return jobRoleDao.jobLocationAscending();
    }

    public List<JobRoleResponse> jobLocationDescending()
            throws SQLException, DatabaseConnectionException {
        return jobRoleDao.jobLocationDescending();
    }

    public List<JobRoleResponse> jobCapabilityAscending()
            throws SQLException, DatabaseConnectionException {
        return jobRoleDao.jobCapabilityAscending();
    }

    public List<JobRoleResponse> jobCapabilityDescending()
            throws SQLException, DatabaseConnectionException {
        return jobRoleDao.jobCapabilityDescending();
    }

    public List<JobRoleResponse> jobBandAscending()
            throws SQLException, DatabaseConnectionException {
        return jobRoleDao.jobBandAscending();
    }

    public List<JobRoleResponse> jobBandDescending()
            throws SQLException, DatabaseConnectionException {
        return jobRoleDao.jobBandDescending();
    }

    public List<JobRoleResponse> jobClosingDateAscending()
            throws SQLException, DatabaseConnectionException {
        return jobRoleDao.jobClosingDateAscending();
    }

    public List<JobRoleResponse> jobClosingDateDescending()
            throws SQLException, DatabaseConnectionException {
        return jobRoleDao.jobClosingDateDescending();
    }
}
