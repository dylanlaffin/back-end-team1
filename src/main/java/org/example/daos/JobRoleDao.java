package org.example.daos;

import org.example.exceptions.DatabaseConnectionException;
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

            while (resultSet.next()) {
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

    /**
     * DAO method to order job role names in ascending order from the database.
     *
     */
    public List<JobRoleResponse> jobNameAscending()
            throws SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleOrderResponse = new ArrayList<>();
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
                                + "where jobRoleOpen = true "
                                + "Order By jobRoleName;");

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

                    jobRoleOrderResponse.add(jobRoleResponse);
                }
                return jobRoleOrderResponse;
            }
            return jobRoleOrderResponse;
        }
    }

    /**
     * DAO method to order job role names in descending order from the database.
     *
     */
    public List<JobRoleResponse> jobNameDescending()
            throws SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleOrderResponse = new ArrayList<>();
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
                                + "where jobRoleOpen = true "
                                + "Order By jobRoleName DESC;");

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

                    jobRoleOrderResponse.add(jobRoleResponse);
                }
                return jobRoleOrderResponse;
            }
            return jobRoleOrderResponse;
        }
    }

    /**
     * DAO method to order job role location in ascending order from the
     * database.
     *
     */
    public List<JobRoleResponse> jobLocationAscending()
            throws SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleOrderResponse = new ArrayList<>();
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
                                + "where jobRoleOpen = true "
                                + "Order By jobRoleLocation;");

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

                    jobRoleOrderResponse.add(jobRoleResponse);
                }
                return jobRoleOrderResponse;
            }
            return jobRoleOrderResponse;
        }
    }

    /**
     * DAO method to order job role location in descending order from the
     * database.
     *
     */
    public List<JobRoleResponse> jobLocationDescending()
            throws SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleOrderResponse = new ArrayList<>();
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
                                + "where jobRoleOpen = true "
                                + "Order By jobRoleLocation DESC;");

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

                    jobRoleOrderResponse.add(jobRoleResponse);
                }
                return jobRoleOrderResponse;
            }
            return jobRoleOrderResponse;
        }
    }

    /**
     * DAO method to order job role capability in ascending order from the
     * database.
     *
     */
    public List<JobRoleResponse> jobCapabilityAscending()
            throws SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleOrderResponse = new ArrayList<>();
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
                                + "where jobRoleOpen = true "
                                + "Order By capabilityName;");

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

                    jobRoleOrderResponse.add(jobRoleResponse);
                }
                return jobRoleOrderResponse;
            }
            return jobRoleOrderResponse;
        }
    }

    /**
     * DAO method to order job role capability in descending order from the
     * database.
     *
     */
    public List<JobRoleResponse> jobCapabilityDescending()
            throws SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleOrderResponse = new ArrayList<>();
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
                                + "where jobRoleOpen = true "
                                + "Order By capabilityName DESC;");

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

                    jobRoleOrderResponse.add(jobRoleResponse);
                }
                return jobRoleOrderResponse;
            }
            return jobRoleOrderResponse;
        }
    }

    /**
     * DAO method to order job band names in Ascending order from the database.
     *
     */
    public List<JobRoleResponse> jobBandAscending()
            throws SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleOrderResponse = new ArrayList<>();
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
                                + "where jobRoleOpen = true "
                                + "Order By bandName;");

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

                    jobRoleOrderResponse.add(jobRoleResponse);
                }
                return jobRoleOrderResponse;
            }
            return jobRoleOrderResponse;
        }
    }

    /**
     * DAO method to order job band names in Ascending order from the database.
     *
     */
    public List<JobRoleResponse> jobBandDescending()
            throws SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleOrderResponse = new ArrayList<>();
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
                                + "where jobRoleOpen = true "
                                + "Order By bandName DESC;");

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

                    jobRoleOrderResponse.add(jobRoleResponse);
                }
                return jobRoleOrderResponse;
            }
            return jobRoleOrderResponse;
        }
    }
    /**
     * DAO method to order job closing date in Ascending order from the
     * database.
     *
     */
    public List<JobRoleResponse> jobClosingDateAscending()
            throws SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleOrderResponse = new ArrayList<>();
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
                                + "where jobRoleOpen = true "
                                + "Order By jobRoleClosingDate;");

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

                    jobRoleOrderResponse.add(jobRoleResponse);
                }
                return jobRoleOrderResponse;
            }
            return jobRoleOrderResponse;
        }
    }

    /**
     * DAO method to order job closing date in descending order from the
     * database.
     *
     */
    public List<JobRoleResponse> jobClosingDateDescending()
            throws SQLException, DatabaseConnectionException {
        List<JobRoleResponse> jobRoleOrderResponse = new ArrayList<>();
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
                                + "where jobRoleOpen = true "
                                + "Order By jobRoleClosingDate DESC;");

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

                    jobRoleOrderResponse.add(jobRoleResponse);
                }
                return jobRoleOrderResponse;
            }
            return jobRoleOrderResponse;
        }
    }

}
