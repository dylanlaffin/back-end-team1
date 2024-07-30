package org.example.controller;

import org.example.controllers.JobRoleController;
import org.example.exceptions.DatabaseConnectionException;
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

    private final OpenJobRoleResponse jobRoleResponse = new OpenJobRoleResponse(
            "MaryJane1",
            Locations.BELFAST,
            "HR",
            "Associate",
            new Date(2024 - 7 - 15),
            1);

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
}
