package org.example.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.example.exceptions.DatabaseConnectionException;
import org.example.exceptions.InvalidException;
import org.example.models.ApplicationRequest;
import org.example.models.UserRole;
import org.example.services.ApplicationsService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Applications API")
@Path("/api/applications")
public class ApplicationsController {
    ApplicationsService applicationsService;

    public ApplicationsController(
            final ApplicationsService applicationsService) {
        this.applicationsService = applicationsService;
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.ADMIN, UserRole.USER})
    @ApiOperation(
            value = "Returns all open job roles",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = Boolean.class
    )
    public Response addApplication(final ApplicationRequest request)
            throws DatabaseConnectionException {
        try {
            return Response.ok().entity(applicationsService.addApplication(
                    request)).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        } catch (InvalidException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to add application").build();
        }
    }
}
