package org.example.services;

import org.example.daos.ApplicationsDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.ApplicationRequest;

import java.sql.SQLException;

public class ApplicationsService {
    final ApplicationsDao applicationsDao;

    public ApplicationsService(final ApplicationsDao applicationsDao) {
        this.applicationsDao = applicationsDao;
    }

    public boolean updateApplication(final ApplicationRequest request)
            throws DatabaseConnectionException, SQLException {
        return applicationsDao.updateStatus(request);
    }
}
