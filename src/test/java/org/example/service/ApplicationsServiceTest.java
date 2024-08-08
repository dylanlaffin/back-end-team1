package org.example.service;

import org.example.daos.ApplicationsDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.exceptions.InvalidException;
import org.example.models.ApplicationRequest;
import org.example.services.ApplicationsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static org.mockito.Mockito.when;

public class ApplicationsServiceTest {
    ApplicationsDao applicationsDao = Mockito.mock(ApplicationsDao.class);

    ApplicationsService applicationsService = new ApplicationsService(
            applicationsDao);

    final ApplicationRequest request = new ApplicationRequest("user",
            "IN_PROGRESS", "testurl.com");

    @Test
    void addApplication_shouldReturnTrue_whenValidRequestPassedIn()
            throws DatabaseConnectionException, SQLException, InvalidException {
        when(applicationsDao.addNewApplication(request)).thenReturn(true);

        Boolean result = applicationsService.addApplication(request);

        Assertions.assertEquals(true, result);
    }

    @Test
    void addApplication_shouldThrowInvalidException_whenResultIsFalse()
            throws DatabaseConnectionException, SQLException, InvalidException {
        when(applicationsDao.addNewApplication(request)).thenReturn(false);

        Assertions.assertThrows(InvalidException.class, () -> applicationsService.addApplication(request));
    }
}
