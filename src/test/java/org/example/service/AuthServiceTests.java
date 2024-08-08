package org.example.service;

import io.jsonwebtoken.Jwts;
import org.example.exceptions.InvalidException;
import org.example.daos.AuthDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.LoginRequest;
import org.example.models.User;
import org.example.services.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.security.Key;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;

import static org.mockito.Mockito.when;

public class AuthServiceTests {

    AuthDao dao = Mockito.mock(AuthDao.class);

    Key jwtKey = Jwts.SIG.HS256.key().build();
    AuthService service = new AuthService(dao, jwtKey);

    String USERNAME = System.getenv().get("LOGIN_USER");
    String PASSWORD = System.getenv().get("LOGIN_PASS");

    @Test
    void login_shouldReturnJwtToken_whenUserSuccessfullyLogsIn()
            throws SQLException, InvalidException, DatabaseConnectionException {

        LoginRequest login = new LoginRequest("admin", "admin");

        when(dao.getUser(login))
                .thenReturn(
                        new User(USERNAME, PASSWORD, 1));

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
            throws SQLException, DatabaseConnectionException {
        LoginRequest login = new LoginRequest(USERNAME, "invalidpassword1234");

        when(dao.getUser(login)).thenReturn(null);

        Assertions.assertThrows(InvalidException.class,
                () -> service.login(login));
    }
}
