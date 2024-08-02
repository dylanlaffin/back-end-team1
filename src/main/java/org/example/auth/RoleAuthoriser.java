package org.example.auth;

import io.dropwizard.auth.Authorizer;
import org.example.models.JwtToken;

public class RoleAuthoriser implements Authorizer<JwtToken> {
    @Override
    public boolean authorize(final JwtToken jwtToken, final String s) {
        return jwtToken.getUserRole().getRoleName().equals(s);
    }
}
