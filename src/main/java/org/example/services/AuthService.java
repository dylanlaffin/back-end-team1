package org.example.services;

import io.jsonwebtoken.Jwts;
import org.example.Exceptions.InvalidException;
import org.example.daos.AuthDao;
import org.example.models.LoginRequest;
import org.example.models.User;

import java.security.Key;
import java.sql.Date;
import java.sql.SQLException;


public class AuthService {
    private final AuthDao dao;
    private final Key key;

    public AuthService(final AuthDao dao, final Key key) {
        this.dao = dao;
        this.key = key;
    }

    public String login(final LoginRequest login) throws SQLException,
            InvalidException {
        User user = dao.getUser(login);

        if (user == null) {
            throw new InvalidException("Username or password was incorrect");
        }

        return generateJwtToken(user);
    }

    private String generateJwtToken(final User user) {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 28800000))
                .claim("Role", user.getRoleId())
                .subject(user.getUsername())
                .issuer("team1-api")
                .signWith(key)
                .compact();
    }
}
