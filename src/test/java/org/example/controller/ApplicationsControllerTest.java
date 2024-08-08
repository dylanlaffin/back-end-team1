package org.example.controller;

import org.example.controllers.ApplicationsController;
import org.example.exceptions.DatabaseConnectionException;
import org.example.exceptions.InvalidException;
import org.example.models.ApplicationRequest;
import org.example.services.ApplicationsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

import static org.mockito.Mockito.when;

public class ApplicationsControllerTest {
    ApplicationsService applicationsService = Mockito.mock(
            ApplicationsService.class);

    private final ApplicationsController applicationsController = new
            ApplicationsController(applicationsService);

    final ApplicationRequest request = new ApplicationRequest("user",
            "IN_PROGRESS", "testurl.com");

    @Test
    void addApplication_shouldAddNewApplicationToDatabase_whenValidRequestSent()
            throws DatabaseConnectionException, SQLException, InvalidException {

        when(applicationsService.addApplication(request)).thenReturn(true);

        Response response = applicationsController.addApplication(request);

        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertEquals(true, response.getEntity());
    }

    @Test
    void addApplication_shouldReturnErrorCode500_whenSQLExceptionThrown()
            throws DatabaseConnectionException, SQLException, InvalidException {
        when(applicationsService.addApplication(request)).thenThrow(
                SQLException.class);

        Response response = applicationsController.addApplication(request);

        Assertions.assertEquals(500, response.getStatus());
    }

    @Test
    void addApplication_shouldReturnErrorCode400_whenInvalidExceptionThrown()
            throws DatabaseConnectionException, SQLException, InvalidException {
        when(applicationsService.addApplication(request)).thenThrow(
                InvalidException.class);

        Response response = applicationsController.addApplication(request);

        Assertions.assertEquals(400, response.getStatus());
    }
}
