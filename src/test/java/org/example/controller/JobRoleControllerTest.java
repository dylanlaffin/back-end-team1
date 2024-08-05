package org.example.controller;

import org.example.Exceptions.DoesNotExistException;
import org.example.controllers.JobRoleController;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRoleDetailResponse;
import org.example.models.JobRoleResponse;
import org.example.models.JobRoleSpecification;
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

    JobRoleDetailResponse jobRoleDetailResponse = new JobRoleDetailResponse(
            1,
            "Technical Architect",
            Locations.BELFAST,
            "Delivery",
            "Senior Associate",
            new Date(2024 - 7 - 15),
              new JobRoleSpecification("testurl.com",
            "Test Responsibilities",
            "Test Job Role Descriptions"));

    /*
      When the service getOpenJobRoles returns a JobRoleResponse List
      Expect JobRoleResponse List to be returned in response to GetJobRoles
     */
    @Test
    void getJobRoles_shouldReturnJobRolesResponseList_whenGetAllJobRolesReturnsJobRoleResponseList()
            throws
            SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleResponseList = new ArrayList<>();

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

    /*
        When the Service gets jobRoleById returns a jobRoleResponse
        expect a jobRoleResponse returned
     */
    @Test
    void getJobRoleById_shouldReturnJobRoleResponse_whenGetSuccessful()
            throws DatabaseConnectionException, SQLException,
            DoesNotExistException {
        int id =1;
        when(jobRoleService.getJobRoleById(id)).thenReturn(
                jobRoleDetailResponse);
        Response response = jobRoleController.getJobRoleById(id);
        assertEquals(200, response.getStatus());
        assertEquals(jobRoleDetailResponse, response.getEntity());
    }

    /*
        when the service get jobRoleById returns a SQL exception
        expect 500 to be returned in response
     */
    @Test
    void getJobRoleById_shouldReturn500SQLException_whenGetJobRoleByIdReturnSQLexception()
            throws DatabaseConnectionException, SQLException,
            DoesNotExistException {
        int id =1;
        when(jobRoleService.getJobRoleById(id)).thenThrow(
                SQLException.class);
        Response response = jobRoleController.getJobRoleById(id);
        assertEquals(500, response.getStatus());
    }

    /*
        when the service get jobRoleById returns a DatabaseConnection exception
        expect 500 to be returned in response
     */
    @Test
    void getJobRoleById_shouldReturn500DatabaseConnection_whenGetJobRoleByIdReturnDatabaseException()
            throws DatabaseConnectionException, SQLException,
            DoesNotExistException {
        int id =1;
        when(jobRoleService.getJobRoleById(id)).thenThrow(
                DatabaseConnectionException.class);
        Response response = jobRoleController.getJobRoleById(id);
        assertEquals(500, response.getStatus());

    }

    /*
        when the service get jobRoleById returns a DoesNotExist exception
        expect 500 to be returned in response
     */
    @Test
    void getJobRoleById_shouldReturn500DoesNotExist_whenGetJobRoleByIdReturnNull()
            throws DatabaseConnectionException, SQLException,
            DoesNotExistException {
        int id =1;
        when(jobRoleService.getJobRoleById(id)).thenThrow(DoesNotExistException.class);
        Response response = jobRoleController.getJobRoleById(id);
        assertEquals(404, response.getStatus());

    }

}