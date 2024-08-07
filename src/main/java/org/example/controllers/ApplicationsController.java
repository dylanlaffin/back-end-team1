package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.DatabaseConnectionException;
import org.example.exceptions.InvalidException;
import org.example.models.ApplicationRequest;
import org.example.services.ApplicationsService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
