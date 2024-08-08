package org.example.services;

import org.example.daos.ApplicationsDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.exceptions.InvalidException;
import org.example.models.ApplicationRequest;

import java.sql.SQLException;

public class ApplicationsService {
    final ApplicationsDao applicationsDao;

    public ApplicationsService(final ApplicationsDao applicationsDao) {
        this.applicationsDao = applicationsDao;
    }

    public boolean addApplication(final ApplicationRequest request)
            throws DatabaseConnectionException, SQLException, InvalidException {
        boolean result = applicationsDao.addNewApplication(request);
        if (!result) {
            throw new InvalidException("Failed to add application");
        }
        return true;
    }
}
