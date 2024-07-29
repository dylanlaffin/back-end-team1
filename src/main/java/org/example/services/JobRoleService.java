package org.example.services;

import org.example.Exceptions.DoesNotExistException;
import org.example.Exceptions.Entity;
import org.example.daos.JobRoleDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRoleResponse;
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
        return jobRoleDao.getOpenJobRoles();
    }

    public JobRoleResponse getJobRoleById(final int id)
            throws SQLException, DatabaseConnectionException,
            DoesNotExistException {
        JobRoleResponse jobRoleResponse = jobRoleDao.getJobRoleByID(id);
        if (jobRoleResponse == null) {
            throw new DoesNotExistException(Entity.JOBROLERESPONSE);
        }
        return jobRoleResponse;
    }


}
