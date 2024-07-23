package org.example.daos;

import org.example.exceptions.DatabaseConnectionException;
import org.example.models.Band;
import org.example.models.Capability;
import org.example.models.JobRoleResponse;
import org.example.models.Locations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {

    /**
     * DAO method to getJobRoles from the database.
     *
     */
    public List<JobRoleResponse> getAllJobRoles()
            throws SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleResponses = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "Select jobRoleName, jobRoleLocation,"
                    + "jobRoleCapability, jobRoleBand,"
                    + "jobRoleClosingDate from `jobRole`;");
            while (resultSet.next()) {
                JobRoleResponse jobRoleResponse = new JobRoleResponse(
                        resultSet.getString("jobRoleName"),
                        Locations.valueOf(
                                resultSet.getString("jobRoleLocation")),
                        Capability.valueOf(
                                resultSet.getString("jobRoleCapability")),
                        Band.valueOf(
                                resultSet.getString("jobRoleBand")),
                        resultSet.getDate("jobRoleClosingDate"));

                jobRoleResponses.add(jobRoleResponse);
            }
        }
        return jobRoleResponses;
    }

}
