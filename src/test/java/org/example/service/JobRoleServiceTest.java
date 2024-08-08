package org.example.service;

import org.example.exceptions.DoesNotExistException;
import org.example.daos.JobRoleDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRoleDetailResponse;
import org.example.models.JobRoleResponse;
import org.example.models.JobRoleSpecification;
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

    JobRoleDetailResponse jobRoleDetailResponse = new JobRoleDetailResponse(
            1,
            "Technical Architect",
            Locations.BELFAST,
            "Delivery",
            "Senior Associate",
            new Date(2024 - 7 - 15),
            new JobRoleSpecification(
                    "testurl.com",
                    "Test Responsibilities",
                    "Test Job Role Descriptions"));


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
            throws SQLException, DatabaseConnectionException {
        Mockito.when(jobRoleDao.getJobRoleByID(1)).thenReturn(null);

        assertThrows(DoesNotExistException.class, ()-> jobRoleService.getJobRoleById(1));

    }

    /*
        When the DAO returns a JobRoleResponse List
        Expect JobRoleResponse List to be returned in order response to GetAllJobRoles
    */
    @Test
    void getJobNameByAscending_shouldReturnJobsNames_inAscendingOrder_whenDaoReturnsListOfJobs()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobNameAscending()).thenReturn(
                    jobRoleResponseList);

        assertEquals(jobRoleResponseList, jobRoleService.jobNameByAscending());
    }

    @Test
    void getJobNameDescending_shouldReturnJobNames_inDescendingOrder_whenDaoReturnsJobList()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobNameDescending()).thenReturn(
               jobRoleResponseList);
        assertEquals(jobRoleResponseList, jobRoleService.jobNameDescending());

    }

    @Test
    void getJobLocation_shouldReturnLocation_inAscendingOrder_whenDaoReturnsJobList()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobLocationAscending()).thenReturn(
                jobRoleResponseList);
        assertEquals(jobRoleResponseList, jobRoleService.jobLocationAscending());

    }

    @Test
    void getJobLocation_shouldReturnLocation_inDescendingOrder_whenDaoReturnsJobList()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobLocationDescending()).thenReturn(
                jobRoleResponseList);
        assertEquals(jobRoleResponseList, jobRoleService.jobLocationDescending());

    }

    @Test
    void getJobCapability_shouldReturnCapability_inAscendingOrder_whenDaoReturnsJobList()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobCapabilityAscending()).thenReturn(
                jobRoleResponseList);
        assertEquals(jobRoleResponseList, jobRoleService.jobLocationAscending());

    }

    @Test
    void getJobCapability_shouldReturnCapability_inDescendingOrder_whenDaoReturnsJobList()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobCapabilityDescending()).thenReturn(
                jobRoleResponseList);
        assertEquals(jobRoleResponseList, jobRoleService.jobCapabilityDescending());

    }

    @Test
    void getJobBand_shouldReturnBand_inAscendingOrder_whenDaoReturnsJobList()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobBandAscending()).thenReturn(
                jobRoleResponseList);
        assertEquals(jobRoleResponseList, jobRoleService.jobBandAscending());

    }

    @Test
    void getJobBand_shouldReturnBand_inDescendingOrder_whenDaoReturnsJobList()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobBandDescending()).thenReturn(
                jobRoleResponseList);
        assertEquals(jobRoleResponseList, jobRoleService.jobBandDescending());

    }

    @Test
    void getJobClosingDate_shouldReturnClosingDateAscending_whenDaoReturnsJobList()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobClosingDateAscending()).thenReturn(
                jobRoleResponseList);
        assertEquals(jobRoleResponseList, jobRoleService.jobClosingDateAscending());
    }

    @Test
    void getJobClosingDate_shouldReturnClosingDateDescending_whenDaoReturnsJobList()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobClosingDateDescending()).thenReturn(
                jobRoleResponseList);
        assertEquals(jobRoleResponseList, jobRoleService.jobClosingDateDescending());
    }

    /*
    When the DAO getJobRoles in order returns a SQL Exception
    Expect a SQL Exception to be returned in response to GetAllJobRoles
     */
    @Test
    void getJobNameAscending_shouldReturnASQLException_whenDaoReturnsASQLException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobNameAscending()).thenThrow(
                SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.jobNameByAscending());
    }
    @Test
    void getJobNameDescending_shouldReturnASQLException_whenDaoReturnsASQLException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobNameDescending()).thenThrow(
                SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.jobNameDescending());
    }

    @Test
    void getJobLocationAscending_shouldReturnASQLException_whenDaoReturnsASQLException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobLocationAscending()).thenThrow(
                SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.jobLocationAscending());
    }


    @Test
    void getJobLocationDescending_shouldReturnASQLException_whenDaoReturnsASQLException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobLocationDescending()).thenThrow(
                SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.jobLocationDescending());
    }

    @Test
    void getJobCapabilityAscending_shouldReturnASQLException_whenDaoReturnsASQLException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobCapabilityAscending()).thenThrow(
                SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.jobCapabilityAscending());
    }

    @Test
    void getJobCapabilityDescending_shouldReturnASQLException_whenDaoReturnsASQLException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobCapabilityDescending()).thenThrow(
                SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.jobCapabilityDescending());
    }

    @Test
    void getJobBandAscending_shouldReturnASQLException_whenDaoReturnsASQLException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobBandAscending()).thenThrow(
                SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.jobBandAscending());
    }

    @Test
    void getJobBandDescending_shouldReturnASQLException_whenDaoReturnsASQLException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobBandDescending()).thenThrow(
                SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.jobBandDescending());
    }

    @Test
    void getJobClosingDateAscending_shouldReturnASQLException_whenDaoReturnsASQLException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobClosingDateAscending()).thenThrow(
                SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.jobClosingDateAscending());
    }

    @Test
    void getJobClosingDateDescending_shouldReturnASQLException_whenDaoReturnsASQLException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobClosingDateDescending()).thenThrow(
                SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.jobClosingDateDescending());
    }

    /*
        When the DAO getJobRoles in order returns a Database Connection Exception
       Expect a Database Connection Exception to be returned in response
    */
    @Test
    void jobNameAsc_shouldReturnADatabaseConnectionException_whenDaoReturnsADatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobNameAscending()).thenThrow(
                DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class,
                () -> jobRoleService.jobNameByAscending());
    }

    @Test
    void jobNameDesc_shouldReturnADatabaseConnectionException_whenDaoReturnsADatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobNameDescending()).thenThrow(
                DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class,
                () -> jobRoleService.jobNameDescending());
    }

    @Test
    void jobLocationAsc_shouldReturnADatabaseConnectionException_whenDaoReturnsADatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobLocationAscending()).thenThrow(
                DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class,
                () -> jobRoleService.jobLocationAscending());
    }

    @Test
    void jobLocationDesc_shouldReturnADatabaseConnectionException_whenDaoReturnsADatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobLocationDescending()).thenThrow(
                DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class,
                () -> jobRoleService.jobLocationDescending());
    }

    @Test
    void jobBandAsc_shouldReturnADatabaseConnectionException_whenDaoReturnsADatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobBandAscending()).thenThrow(
                DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class,
                () -> jobRoleService.jobBandAscending());
    }

    @Test
    void jobBandDesc_shouldReturnADatabaseConnectionException_whenDaoReturnsADatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobBandDescending()).thenThrow(
                DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class,
                () -> jobRoleService.jobBandDescending());
    }

    @Test
    void jobCapabilityAsc_shouldReturnADatabaseConnectionException_whenDaoReturnsADatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobCapabilityAscending()).thenThrow(
                DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class,
                () -> jobRoleService.jobCapabilityAscending());
    }

    @Test
    void jobCapabilityDesc_shouldReturnADatabaseConnectionException_whenDaoReturnsADatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobCapabilityDescending()).thenThrow(
                DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class,
                () -> jobRoleService.jobCapabilityDescending());
    }

    @Test
    void jobClosingDateAsc_shouldReturnADatabaseConnectionException_whenDaoReturnsADatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobClosingDateAscending()).thenThrow(
                DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class,
                () -> jobRoleService.jobClosingDateAscending());
    }

    @Test
    void jobClosingDateDesc_shouldReturnADatabaseConnectionException_whenDaoReturnsADatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {

        Mockito.when(jobRoleDao.jobClosingDateDescending()).thenThrow(
                DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class,
                () -> jobRoleService.jobClosingDateDescending());
    }



}
