package org.example.auth;

import io.dropwizard.auth.Authenticator;
import io.jsonwebtoken.Jwts;
import org.example.models.JwtToken;

import javax.naming.AuthenticationException;
import java.security.Key;
import java.util.Optional;

public class JwtAuthenticator implements Authenticator<String, JwtToken> {
    Key key;

    public JwtAuthenticator(final Key key) {
        this.key = key;
    }

    @Override
    public Optional<JwtToken> authenticate(String token) throws
            AuthenticationException {
        try {
            Integer roleId = Jwts.parser()
                    .setSigningKey(key)
                    .parseSignedClaims(token)
                    .getPayload()
                    .get("Role", Integer.class);
        }
    }
}
