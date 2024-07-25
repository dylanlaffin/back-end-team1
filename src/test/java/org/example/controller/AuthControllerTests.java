package org.example.controller;


import io.jsonwebtoken.Jwts;
import org.example.Exceptions.InvalidException;
import org.example.controllers.AuthController;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.LoginRequest;
import org.example.services.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AuthControllerTests {
    String USERNAME = System.getenv().get("LOGIN_USER");
    String PASSWORD = System.getenv().get("LOGIN_PASS");
    AuthService authenticatorService = Mockito.mock(AuthService.class);

    private final AuthController authenticatorController = new AuthController(authenticatorService);

    private final LoginRequest login = new LoginRequest(USERNAME, PASSWORD);

    @Test
    void login_shouldReturnJwtToken_whenValidCredentialsAreUsed()
            throws SQLException, InvalidException, DatabaseConnectionException {
        String token = Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 28800000))
                .claim("Role", 1)
                .subject("admin")
                .issuer("team1-api")
                .signWith(Jwts.SIG.HS256.key().build())
                .compact();
        when(authenticatorService.login(login)).thenReturn(token);

        Response response = authenticatorController.login(login);

        String[] respChunks = response.getEntity().toString().split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String body = new String(decoder.decode(respChunks[1]));

        Assertions.assertTrue(body.contains("\"Role\":1")
                && body.contains("\"sub\":\"admin\"")
                && body.contains("\"iss\":\"team1-api\""));

        Assertions.assertEquals(token, response.getEntity());

        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    void login_shouldReturnErrorCode500_whenSqlExceptionThrown()
            throws SQLException, InvalidException, DatabaseConnectionException {
        when(authenticatorService.login(login)).thenThrow(SQLException.class);

        assertEquals(500, authenticatorController.login(login).getStatus());
    }

    @Test
    void login_shouldReturnErrorCode400_whenInvalidExceptionThrown()
            throws SQLException, InvalidException, DatabaseConnectionException {
        when(authenticatorService.login(login)).thenThrow(InvalidException.class);

        assertEquals(400, authenticatorController.login(login).getStatus());
    }
}
