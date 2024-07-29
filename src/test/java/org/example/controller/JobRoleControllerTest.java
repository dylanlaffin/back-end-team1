package org.example.controller;

import org.example.Exceptions.DoesNotExistException;
import org.example.controllers.JobRoleController;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRoleResponse;
import org.example.models.OpenJobRoleResponse;
import org.example.models.Locations;
import org.example.services.JobRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class JobRoleControllerTest {
    JobRoleService jobRoleService = Mockito.mock(JobRoleService.class);

    private final JobRoleController jobRoleController =
            new JobRoleController(jobRoleService);

    private final OpenJobRoleResponse openJobRoleResponse = new OpenJobRoleResponse(
            1,
            "MaryJane1",
            Locations.BELFAST,
            "HR",
            "Associate",
            new Date(2024 - 7 - 15));

    JobRoleResponse jobRoleResponse = new JobRoleResponse(
            "Technical Architect",
            Locations.BELFAST,
            "Delivery",
            "Senior Associate",
            new Date(2024 - 7 - 15),
            "testurl.com",
            "Test Responsibilities",
            "Test Job Role Descriptions");

    /*
      When the service getOpenJobRoles returns a JobRoleResponse List
      Expect JobRoleResponse List to be returned in response to GetJobRoles
     */
    @Test
    void getJobRoles_shouldReturnJobRolesResponseList_whenGetAllJobRolesReturnsJobRoleResponseList()
            throws
            SQLException, DatabaseConnectionException {
        List<OpenJobRoleResponse> jobRoleResponseList = new ArrayList<>();

        when(jobRoleService.getOpenJobRoles()).thenReturn(jobRoleResponseList);

        Response response = jobRoleController.getJobRoles();
        assertEquals(200, response.getStatus());
        assertEquals(jobRoleResponseList, response.getEntity());
    }

    /*
      When the service getOpenJobRoles returns a SQLException
      Expect 500 to be returned in response to GetJobRoles
     */
    @Test
    void getJobRoles_shouldReturn500SQLException_whenGetAllJobRolesReturnsASQLException()
            throws
            SQLException, DatabaseConnectionException {

        when(jobRoleService.getOpenJobRoles()).thenThrow(SQLException.class);

        Response response = jobRoleController.getJobRoles();

        assertEquals(500, response.getStatus());
    }

    /*
          When the service getOpenJobRoles returns a DataBaseConnectionException
          Expect 500 to be returned in response to GetJobRoles
         */
    @Test
    void getJobRoles_shouldReturn500DatabaseConnectionException_whenGetAllJobRolesReturnsADatabaseConnectionException()
            throws
            SQLException, DatabaseConnectionException {

        when(jobRoleService.getOpenJobRoles()).thenThrow(
                DatabaseConnectionException.class);

        Response response = jobRoleController.getJobRoles();

        assertEquals(500, response.getStatus());
    }

    @Test
    void getJobRoleById_shouldReturnJobRoleResponse_whenGetSuccessful()
            throws DatabaseConnectionException, SQLException,
            DoesNotExistException {
        int id =1;
        when(jobRoleService.getJobRoleById(id)).thenThrow(
                DatabaseConnectionException.class);
        Response response = jobRoleController.getJobRoleById(id);
        assertEquals(200, response.getStatus());
        assertEquals(openJobRoleResponse, response.getEntity());

    }
}