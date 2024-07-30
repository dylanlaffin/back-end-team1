package org.example.daos;

import org.example.exceptions.DatabaseConnectionException;
import org.example.models.ApplicationRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationsDao {
    public boolean updateStatus(final ApplicationRequest update)
            throws DatabaseConnectionException, SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "UPDATE applications SET "
                    + "StatusID=? WHERE ApplicationID=?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(update.getStatus()));
            ps.setInt(2, update.getApplicationID());

            int result = ps.executeUpdate();

            return result != 0;
        }
    }
}
