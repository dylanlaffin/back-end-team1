package org.example.service;

import org.example.daos.DatabaseConnector;
import org.example.daos.JobRoleDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.Band;
import org.example.models.Capability;
import org.example.models.JobRoleResponse;
import org.example.models.Locations;
import org.example.services.JobRoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class JobRoleServiceTest {

    JobRoleDao jobRoleDao = Mockito.mock(JobRoleDao.class);

    JobRoleService jobRoleService = new JobRoleService(jobRoleDao);

    JobRoleResponse jobRoleResponse = new JobRoleResponse(
            "MaryJane1",
            Locations.BELFAST,
            Capability.DELIVERY,
            Band.BAND2,
            new Date(2024 - 7 - 15));

    List<JobRoleResponse> jobRoleResponseList = new ArrayList<>();
    /*
      When the DAO getAllJobRoles returns a JobRoleResponse List
      Expect JobRoleResponse List to be returned in response to GetAllJobRoles
     */
    @Test
    void getAllJobRoles_shouldReturnAListOfJobRoles_whenDaoReturnsAListOfJobRoles()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.getAllJobRoles()).thenReturn(jobRoleResponseList);

        assertEquals(jobRoleResponseList, jobRoleService.getAllJobRoles());
    }
    /*
         When the DAO getAllJobRoles returns a SQL Exception
        Expect a SQL Exception to be returned in response to GetAllJobRoles
     */
    @Test
    void getAllJobRoles_shouldReturnASQLException_whenDaoReturnsASQLException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.getAllJobRoles()).thenThrow(
                SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.getAllJobRoles());
    }

    /*
         When the DAO getAllJobRoles returns a Database Connection Exception
        Expect a Database Connection Exception to be returned in response to GetAllJobRoles
     */
    @Test
    void getAllJobRoles_shouldReturnADatabaseConnectionException_whenDaoReturnsADatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.getAllJobRoles()).thenThrow(
                DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class,
                () -> jobRoleService.getAllJobRoles());
    }

}
