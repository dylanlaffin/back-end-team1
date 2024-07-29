package org.example.daos;

import com.sun.jdi.connect.spi.TransportService;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRoleResponse;
import org.example.models.OpenJobRoleResponse;
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
    public List<OpenJobRoleResponse> getOpenJobRoles()
            throws SQLException, DatabaseConnectionException {
        List<OpenJobRoleResponse> jobRoleResponses = new ArrayList<>();
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
                    OpenJobRoleResponse
                            jobRoleResponse = new OpenJobRoleResponse(
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
    public JobRoleResponse getJobRoleByID(final int id)
            throws SQLException, DatabaseConnectionException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String query = "Select jobRoleName, jobRoleLocation, "
                    + "capabilityName, bandName, "
                    + "jobRoleClosingDate, "
                    + "jobRoleDescription, "
                    + "jobRoleResponsibilities, "
                    + "jobRoleSpecUrl, "
                    + "from `jobRole`"
                    + "Left Join `capabilty` "
                    + "on jobRole.capabiltyID "
                    + "= capabilty.capabiltyID "
                    + "Left Join `band` "
                    + "on jobRole.bandID = band.bandID "
                    + "where jobRoleID = ?;";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return new JobRoleResponse(resultSet.getString("jobRoleName"),
                        Locations.valueOf(
                                resultSet.getString("jobRoleLocation")),
                        resultSet.getString("capabilityName"),
                        resultSet.getString("bandName"),
                        resultSet.getDate("jobRoleClosingDate"),
                        resultSet.getString("jobRoleClosingDate"),
                        resultSet.getString("jobRoleResponsibilities"),
                        resultSet.getString("jobRoleSpecUrl"));

            }
        }
        return null;
    }




}
