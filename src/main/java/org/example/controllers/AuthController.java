package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.InvalidException;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.LoginRequest;
import org.example.services.AuthService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Auth API")
@Path("/api/auth")
public class AuthController {
    AuthService service;

    public AuthController(final AuthService authService) {
        this.service = authService;
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(final LoginRequest login)
            throws DatabaseConnectionException {
        try {
            return Response.ok().entity(service.login(login)).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        } catch (InvalidException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Username or Password Incorrect").build();
        }
    }
}
