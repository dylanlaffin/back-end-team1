package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.ApplicationRequest;
import org.example.services.ApplicationsService;

import javax.ws.rs.PATCH;
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

    @PATCH
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateApplication(final ApplicationRequest request)
            throws DatabaseConnectionException {
        try {
            return Response.ok().entity(applicationsService.updateApplication(
                    request)).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
