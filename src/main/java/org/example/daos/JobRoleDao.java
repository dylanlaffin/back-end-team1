package org.example.daos;

import org.example.Exceptions.DatabaseConnectionException;
import org.example.models.JobRoleDetailResponse;
import org.example.models.JobRoleResponse;
import org.example.models.JobRoleSpecification;
import org.example.models.Locations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {

    /**
     * DAO method to getJobRoles OPEN jobRoles from database.
     *
     */
    public List<JobRoleResponse> getOpenJobRoles()
            throws SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleResponses = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection()) {
            if (connection != null) {
                Statement statement = connection.createStatement();

                ResultSet resultSet;
                resultSet = statement.executeQuery(
                        "Select jobRoleID, jobRoleName, "
                                + "jobRoleLocation, capabilityName, bandName, "
                                + "jobRoleClosingDate "
                                + "from `jobRole`"
                                + "Left Join `capabilty` "
                                + "on jobRole.capabiltyID "
                                + "= capabilty.capabiltyID "
                                + "Left Join `band` "
                                + "on jobRole.bandID = band.bandID "
                                + "where jobRoleOpen = true;");
                while (resultSet.next()) {
                    JobRoleResponse
                            jobRoleResponse = new JobRoleResponse(
                                    resultSet.getInt("jobRoleID"),
                            resultSet.getString("jobRoleName"),
                            Locations.valueOf(
                                    resultSet.getString("jobRoleLocation")),
                            resultSet.getString("capabilityName"),
                            resultSet.getString("bandName"),
                            resultSet.getDate("jobRoleClosingDate"));

                    jobRoleResponses.add(jobRoleResponse);
                }
                return jobRoleResponses;
            }
            return jobRoleResponses;
        }
    }

    /**
     * DAO method to JobRoles by ID from database.
     *
     */
    public JobRoleDetailResponse getJobRoleByID(final int id)
            throws SQLException, DatabaseConnectionException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String query = "Select jobRoleID, "
                    + "jobRoleName, jobRoleLocation, "
                    + "capabilityName, bandName, "
                    + "jobRoleClosingDate, "
                    + "jobRoleSpecUrl, "
                    + "jobRoleResponsibilities, "
                    + "jobRoleDescription "
                    + "from `jobRole`"
                    + "Left Join `capabilty` "
                    + "on jobRole.capabiltyID "
                    + "= capabilty.capabiltyID "
                    + "Left Join `band` "
                    + "on jobRole.bandID = band.bandID "
                    + "where jobRoleID = ?;";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new JobRoleDetailResponse(
                        resultSet.getInt("jobRoleID"),
                        resultSet.getString("jobRoleName"),
                        Locations.valueOf(
                                resultSet.getString("jobRoleLocation")),
                        resultSet.getString("capabilityName"),
                        resultSet.getString("bandName"),
                        resultSet.getDate("jobRoleClosingDate"),
                        new JobRoleSpecification(
                        resultSet.getString("jobRoleSpecUrl"),
                        resultSet.getString("jobRoleResponsibilities"),
                        resultSet.getString("jobRoleDescription")));
            }
        }
        return null;
    }

}
