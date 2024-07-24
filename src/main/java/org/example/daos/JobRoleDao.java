package org.example.daos;

import org.example.exceptions.DatabaseConnectionException;
import org.example.models.Band;
import org.example.models.Capability;
import org.example.models.OpenJobRoleResponse;
import org.example.models.Locations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {

    /**
     * DAO method to getJobRoles OPEN jobRoles from database
     *
     */
    public List<OpenJobRoleResponse> getOpenJobRoles()
            throws SQLException, DatabaseConnectionException {
        List<OpenJobRoleResponse> jobRoleResponses = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection()) {
            if (connection != null) {
                Statement statement = connection.createStatement();

                ResultSet resultSet;
                resultSet = statement.executeQuery(
                        "Select jobRoleName, jobRoleLocation,"
                                + "jobRoleCapability, jobRoleBand,"
                                + "jobRoleClosingDate from `jobRole` where jobRoleOpen = true;");
                while (resultSet.next()) {
                    OpenJobRoleResponse
                            jobRoleResponse = new OpenJobRoleResponse(
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
                return jobRoleResponses;
            }
            return jobRoleResponses;
        }
    }
}
