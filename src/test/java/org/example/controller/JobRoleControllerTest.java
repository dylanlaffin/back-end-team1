package org.example.controller;

import org.example.controllers.JobRoleController;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.Band;
import org.example.models.Capability;
import org.example.models.JobRoleResponse;
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

    private final JobRoleResponse jobRoleResponse = new JobRoleResponse(
            "MaryJane1",
            Locations.BELFAST,
            Capability.DELIVERY,
            Band.BAND2,
            new Date(2024 - 7 - 15));

    /*
      When the service getAllJobRoles returns a JobRoleResponse List
      Expect JobRoleResponse List to be returned in response to GetJobRoles
     */
    @Test
    void getJobRoles_shouldReturnJobRolesResponseList_whenGetAllJobRolesReturnsJobRoleResponseList()
            throws
            SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleResponseList = new ArrayList<>();

        when(jobRoleService.getAllJobRoles()).thenReturn(jobRoleResponseList);

        Response response = jobRoleController.getJobRoles();

        assertEquals(jobRoleResponseList, response.getEntity());
    }
    /*
      When the service getAllJobRoles returns a SQLException
      Expect 500 to be returned in response to GetJobRoles
     */
    @Test
    void getJobRoles_shouldReturn500SQLException_whenGetAllJobRolesReturnsASQLException()
            throws
            SQLException, DatabaseConnectionException {

        when(jobRoleService.getAllJobRoles()).thenThrow(SQLException.class);

        Response response = jobRoleController.getJobRoles();

        assertEquals(500, response.getStatus());
    }
    /*
          When the service getAllJobRoles returns a DataBaseConnectionException
          Expect 500 to be returned in response to GetJobRoles
         */
    @Test
    void getJobRoles_shouldReturn500DatabaseConnectionException_whenGetAllJobRolesReturnsADatabaseConnectionException()
            throws
            SQLException, DatabaseConnectionException {

        when(jobRoleService.getAllJobRoles()).thenThrow(
                DatabaseConnectionException.class);

        Response response = jobRoleController.getJobRoles();

        assertEquals(500, response.getStatus());
    }
}
