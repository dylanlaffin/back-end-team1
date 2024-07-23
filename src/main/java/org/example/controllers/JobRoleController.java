package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.DatabaseConnectionException;
import org.example.services.JobRoleService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Team1-API")
@Path("/api/jobRoles")
public class JobRoleController {
    /*
    instatiates the JOb role services
     */
    private final JobRoleService jobRoleService;

    public JobRoleController(
            final JobRoleService jobRoleSrv) {
        this.jobRoleService = jobRoleSrv;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRoles() {
        try {
            return Response.ok().entity(
                    jobRoleService.getAllJobRoles()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        }
    }

}
