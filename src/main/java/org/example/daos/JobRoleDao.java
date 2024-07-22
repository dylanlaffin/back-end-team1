package org.example.daos;

import org.example.models.Band;
import org.example.models.Capability;
import org.example.models.JobRole;
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
    public List<JobRole> getAllJobRoles() throws SQLException {
        List<JobRole> jobRoles = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "Select jobRoleID, jobRoleName, jobRoleLocation,"
                    + "jobRoleCapability, jobRoleBand,"
                    + "jobRoleClosingDate from `jobRole`;");
            while (resultSet.next()) {
                JobRole jobRole = new JobRole(
                        resultSet.getInt("jobRoleID"),
                        resultSet.getString("jobRoleName"),
                        Locations.valueOf(
                                resultSet.getString("jobRoleLocation")),
                        Capability.valueOf(
                                resultSet.getString("jobRoleCapability")),
                        Band.valueOf(
                                resultSet.getString("jobRoleBand")),
                        resultSet.getDate("jobRoleClosingDate"));

                jobRoles.add(jobRole);
            }
        }
        return jobRoles;
    }
}
