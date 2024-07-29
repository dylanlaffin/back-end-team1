package org.example.service;

import org.example.Exceptions.DoesNotExistException;
import org.example.daos.JobRoleDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRoleDetailResponse;
import org.example.models.JobRoleResponse;
import org.example.models.Locations;
import org.example.services.JobRoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
            1,
            "MaryJane1",
            Locations.BELFAST,
            "Delivery",
            "Associate",
            new Date(2024 - 7 - 15));

    JobRoleDetailResponse jobRoleDetailResponse = new JobRoleDetailResponse(
            1,
            "Technical Architect",
            Locations.BELFAST,
            "Delivery",
            "Senior Associate",
            new Date(2024 - 7 - 15),
            "testurl.com",
                    "Test Responsibilities",
                    "Test Job Role Descriptions");


    List<JobRoleResponse> jobRoleResponseList = new ArrayList<>();
    /*
      When the DAO getOpenJobRoles returns a JobRoleResponse List
      Expect JobRoleResponse List to be returned in response to GetAllJobRoles
     */
    @Test
    void getOpenJobRoles_shouldReturnAListOfJobRoles_whenDaoReturnsAListOfJobRoles()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.getOpenJobRoles()).thenReturn(
                jobRoleResponseList);

        assertEquals(jobRoleResponseList, jobRoleService.getOpenJobRoles());
    }
    /*
         When the DAO getOpenJobRoles returns a SQL Exception
        Expect a SQL Exception to be returned in response to GetAllJobRoles
     */
    @Test
    void getOpenJobRoles_shouldReturnASQLException_whenDaoReturnsASQLException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.getOpenJobRoles()).thenThrow(
                SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.getOpenJobRoles());
    }

    /*
         When the DAO getOpenJobRoles returns a Database Connection Exception
        Expect a Database Connection Exception to be returned in response to GetAllJobRoles
     */
    @Test
    void getOpenJobRoles_shouldReturnADatabaseConnectionException_whenDaoReturnsADatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.getOpenJobRoles()).thenThrow(
                DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class,
                () -> jobRoleService.getOpenJobRoles());
    }

    @Test
    void getJobRolesById_shouldReturnJobRoleResponse_whenDaoReturnsJobRoleResponse()
        throws SQLException, DatabaseConnectionException, DoesNotExistException {
            Mockito.when(jobRoleDao.getJobRoleByID(1)).thenReturn(
                    jobRoleDetailResponse);

            assertEquals(jobRoleDetailResponse, jobRoleService.getJobRoleById(1));

        }

    @Test
    void getJobRolesById_shouldThrowSQLException_whenDaoThrowsSQLException()
            throws SQLException, DatabaseConnectionException {
        Mockito.when(jobRoleDao.getJobRoleByID(1)).thenThrow(SQLException.class);

        assertThrows(SQLException.class, ()-> jobRoleService.getJobRoleById(1));

    }

    @Test
    void getJobRolesById_shouldThrowDatabaseException_whenDaoThrowsDatabaseException()
            throws SQLException, DatabaseConnectionException {
        Mockito.when(jobRoleDao.getJobRoleByID(1)).thenThrow(DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class, ()-> jobRoleService.getJobRoleById(1));

    }

    @Test
    void getJobRolesById_shouldThrowDoesNotExistException_whenDaoReturnsNull()
            throws SQLException, DatabaseConnectionException, DoesNotExistException {
        Mockito.when(jobRoleDao.getJobRoleByID(1)).thenReturn(null);

        assertThrows(DoesNotExistException.class, ()-> jobRoleService.getJobRoleById(1));

    }

}
