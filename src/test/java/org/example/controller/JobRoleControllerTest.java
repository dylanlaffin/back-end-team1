package org.example.controller;

import org.example.exceptions.DoesNotExistException;
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

    private final JobRoleResponse jobRoleResponse = new JobRoleResponse(
            1,
            "MaryJane1",
            Locations.BELFAST,
            "HR",
            "Associate",
            new Date(2024 - 7 - 15));

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

    /*
      When the service getOpenJobRoles in order returns an ordered JobRoleResponse List
      Expect ordered JobRoleResponse List to be returned in response to GetJobRoles
     */
    @Test
    void getJobRolesByOrder_shouldReturnJobRolesResponseList_whenGetAllJobRolesReturnsJobRoleResponseList()
            throws
            SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleResponseList = new ArrayList<>();
        String order1 = "asc";
        String order2 = "desc";
        String name = "name";
        String capability = "capability";
        String band = "band";
        String location = "location";
        String closingDate= "closingDate";

        when(jobRoleService.getOpenJobRoles()).thenReturn(jobRoleResponseList);

        Response response = jobRoleController.getJobRolesByOrder(order1,name);
        assertEquals(200, response.getStatus());
        assertEquals(jobRoleResponseList, response.getEntity());

        Response response2 = jobRoleController.getJobRolesByOrder(order2,name);
        assertEquals(200, response2.getStatus());
        assertEquals(jobRoleResponseList, response2.getEntity());

        Response response3 = jobRoleController.getJobRolesByOrder(order1,band);
        assertEquals(200, response3.getStatus());
        assertEquals(jobRoleResponseList, response3.getEntity());

        Response response4 = jobRoleController.getJobRolesByOrder(order2,band);
        assertEquals(200, response4.getStatus());
        assertEquals(jobRoleResponseList, response4.getEntity());

        Response response5 = jobRoleController.getJobRolesByOrder(order1,capability);
        assertEquals(200, response5.getStatus());
        assertEquals(jobRoleResponseList, response5.getEntity());

        Response response6 = jobRoleController.getJobRolesByOrder(order2, capability);
        assertEquals(200, response6.getStatus());
        assertEquals(jobRoleResponseList, response6.getEntity());

        Response response7 = jobRoleController.getJobRolesByOrder(order1,location);
        assertEquals(200, response7.getStatus());
        assertEquals(jobRoleResponseList, response7.getEntity());

        Response response8 = jobRoleController.getJobRolesByOrder(order2,location);
        assertEquals(200, response8.getStatus());
        assertEquals(jobRoleResponseList, response8.getEntity());

        Response response9 = jobRoleController.getJobRolesByOrder(order1,closingDate);
        assertEquals(200, response9.getStatus());
        assertEquals(jobRoleResponseList, response9.getEntity());

        Response response10 = jobRoleController.getJobRolesByOrder(order2,closingDate);
        assertEquals(200, response10.getStatus());
        assertEquals(jobRoleResponseList, response10.getEntity());

    }

    /*
      When the service getOpenJobRoles returns a SQLException
      Expect 500 to be returned in response to GetJobRoles
     */
    @Test
    void getJobRolesByOrder_shouldReturn500SQLException_whenGetAllJobRolesReturnsASQLException()
            throws
            SQLException, DatabaseConnectionException {

        String order1 = "asc";
        String order2 = "desc";
        String name = "name";
        String capability = "capability";
        String band = "band";
        String location = "location";
        String closingDate= "closingDate";

        when(jobRoleService.jobNameByAscending()).thenThrow(SQLException.class);
        Response response = jobRoleController.getJobRolesByOrder(order1,name);
        assertEquals(500, response.getStatus());

        when(jobRoleService.jobNameDescending()).thenThrow(SQLException.class);
        Response response2 = jobRoleController.getJobRolesByOrder(order2,name);
        assertEquals(500, response2.getStatus());

        when(jobRoleService.jobBandAscending()).thenThrow(SQLException.class);
        Response response3 = jobRoleController.getJobRolesByOrder(order1,band);
        assertEquals(500, response3.getStatus());

        when(jobRoleService.jobBandDescending()).thenThrow(SQLException.class);
        Response response4 = jobRoleController.getJobRolesByOrder(order2,band);
        assertEquals(500, response4.getStatus());

        when(jobRoleService.jobCapabilityAscending()).thenThrow(SQLException.class);
        Response response5 = jobRoleController.getJobRolesByOrder(order1,capability);
        assertEquals(500, response5.getStatus());

        when(jobRoleService.jobCapabilityDescending()).thenThrow(SQLException.class);
        Response response6 = jobRoleController.getJobRolesByOrder(order2,capability);
        assertEquals(500, response6.getStatus());

        when(jobRoleService.jobLocationAscending()).thenThrow(SQLException.class);
        Response response7 = jobRoleController.getJobRolesByOrder(order1,location);
        assertEquals(500, response7.getStatus());

        when(jobRoleService.jobLocationDescending()).thenThrow(SQLException.class);
        Response response8 = jobRoleController.getJobRolesByOrder(order2,location);
        assertEquals(500, response8.getStatus());

        when(jobRoleService.jobClosingDateAscending()).thenThrow(SQLException.class);
        Response response9 = jobRoleController.getJobRolesByOrder(order1,closingDate);
        assertEquals(500, response9.getStatus());

        when(jobRoleService.jobClosingDateDescending()).thenThrow(SQLException.class);
        Response response10 = jobRoleController.getJobRolesByOrder(order2,closingDate);
        assertEquals(500, response4.getStatus());


    }

    /*
         When the service getOpenJobRoles in order returns a DataBaseConnectionException
         Expect 500 to be returned in response to GetJobRoles
        */
    @Test
    void getJobRolesByOrder_shouldReturn500DatabaseConnectionException_whenGetAllJobRolesReturnsADatabaseConnectionException()
            throws
            SQLException, DatabaseConnectionException {
        String order1 = "asc";
        String order2 = "desc";
        String name = "name";
        String capability = "capability";
        String band = "band";
        String location = "location";
        String closingDate= "closingDate";

        when(jobRoleService.jobNameByAscending()).thenThrow(DatabaseConnectionException.class);
        Response response = jobRoleController.getJobRolesByOrder(order1,name);
        assertEquals(500, response.getStatus());

        when(jobRoleService.jobNameDescending()).thenThrow(DatabaseConnectionException.class);
        Response response2 = jobRoleController.getJobRolesByOrder(order2,name);
        assertEquals(500, response2.getStatus());

        when(jobRoleService.jobBandAscending()).thenThrow(DatabaseConnectionException.class);
        Response response3 = jobRoleController.getJobRolesByOrder(order1,band);
        assertEquals(500, response3.getStatus());

        when(jobRoleService.jobBandDescending()).thenThrow(DatabaseConnectionException.class);
        Response response4 = jobRoleController.getJobRolesByOrder(order2,band);
        assertEquals(500, response4.getStatus());

        when(jobRoleService.jobCapabilityAscending()).thenThrow(DatabaseConnectionException.class);
        Response response5 = jobRoleController.getJobRolesByOrder(order1,capability);
        assertEquals(500, response5.getStatus());

        when(jobRoleService.jobCapabilityDescending()).thenThrow(DatabaseConnectionException.class);
        Response response6 = jobRoleController.getJobRolesByOrder(order2,capability);
        assertEquals(500, response6.getStatus());

        when(jobRoleService.jobLocationAscending()).thenThrow(DatabaseConnectionException.class);
        Response response7 = jobRoleController.getJobRolesByOrder(order1,location);
        assertEquals(500, response7.getStatus());

        when(jobRoleService.jobLocationDescending()).thenThrow(DatabaseConnectionException.class);
        Response response8 = jobRoleController.getJobRolesByOrder(order2,location);
        assertEquals(500, response8.getStatus());

        when(jobRoleService.jobClosingDateAscending()).thenThrow(DatabaseConnectionException.class);
        Response response9 = jobRoleController.getJobRolesByOrder(order1,closingDate);
        assertEquals(500, response9.getStatus());

        when(jobRoleService.jobClosingDateDescending()).thenThrow(DatabaseConnectionException.class);
        Response response10 = jobRoleController.getJobRolesByOrder(order2,closingDate);
        assertEquals(500, response4.getStatus());




    }


}