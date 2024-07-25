package org.example.daos;

import org.example.models.LoginRequest;
import org.example.models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDao {
    public User getUser(final LoginRequest login) throws SQLException {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT Username, Password, RoleID FROM `User` "
                    + "WHERE Username = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, login.getUsername());
            ResultSet rs = ps.executeQuery();

            if (rs.next() && BCrypt.checkpw(login.getPassword(),
                    rs.getString("Password"))) {
                return new User(
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("RoleID")
                );
            }
        }
        return null;
    }
}
