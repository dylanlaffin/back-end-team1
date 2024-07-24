package org.example.service;

import io.jsonwebtoken.Jwts;
import org.example.Exceptions.InvalidException;
import org.example.controllers.AuthController;
import org.example.daos.AuthDao;
import org.example.daos.DatabaseConnector;
import org.example.models.LoginRequest;
import org.example.models.User;
import org.example.services.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import java.security.Key;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AuthServiceTests {

    AuthDao dao = Mockito.mock(AuthDao.class);

    Key jwtKey = Jwts.SIG.HS256.key().build();
    AuthService service = new AuthService(dao, jwtKey);

    Connection conn;

    @Test
    void login_shouldReturnJwtToken_whenUserSuccessfullyLogsIn()
            throws SQLException, InvalidException {
        LoginRequest login = new LoginRequest("admin", "admin");

        when(dao.getUser(login))
                .thenReturn(
                        new User("admin", "admin", 1));

        String result = service.login(login);

        String[] respChunks = result.split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String body = new String(decoder.decode(respChunks[1]));

        Assertions.assertTrue(body.contains("\"Role\":1")
                && body.contains("\"sub\":\"admin\"")
                && body.contains("\"iss\":\"team1-api\""));
    }

    @Test
    void login_shouldThrowInvalidException_whenInvalidCredentialsAreGiven()
            throws SQLException, InvalidException {
        LoginRequest login = new LoginRequest("admin", "user");

        when(dao.getUser(login)).thenReturn(null);

        Assertions.assertThrows(InvalidException.class,
                () -> service.login(login));
    }
}
