package org.example.daos;

import org.example.exceptions.DatabaseConnectionException;
import org.example.models.ApplicationRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationsDao {
    public boolean addNewApplication(final ApplicationRequest addition)
            throws DatabaseConnectionException, SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO applications(Username, StatusID,"
                    + " ApplicationURL) VALUES (?, ?, ?)";


            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, addition.getUsername());
            ps.setInt(2, getStatusID(addition.getStatus()));
            ps.setString(3, addition.getApplicationURL());

            return ps.executeUpdate() != 0;
        }
    }

    private int getStatusID(final String status) {
        switch (status) {
            case "HIRED":
                return 1;
            case "REJECTED":
                return 2;
            case "IN_PROGRESS":
                return 3;
            default:
                return -1;
        }
    }
}
