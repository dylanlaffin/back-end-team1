package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.DoesNotExistException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRoleResponse;
import org.example.models.UserRole;
import org.example.services.JobRoleService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Api("Team1-Job Role API")
@Path("/api/openJobRoles")
public class JobRoleController {
    /*
    instatiates the Job role services
     */
    private final JobRoleService jobRoleService;

    public JobRoleController(
            final JobRoleService jobRoleSrv) {
        this.jobRoleService = jobRoleSrv;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.ADMIN, UserRole.USER})
    @ApiOperation(
            value = "Returns all open job roles",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = List.class
    )
    public Response getJobRoles() {
        try {
            return Response.ok().entity(
                    jobRoleService.getOpenJobRoles()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        }
    }
    /*Returns a JobRoleDetailResponse when getRoleByID is requested*/
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.ADMIN, UserRole.USER})
    @ApiOperation(
            value = "Returns specific open job role",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = JobRoleResponse.class
    )
    public Response getJobRoleById(@PathParam("id") final int id) {
        try {
            return Response.ok().entity(
                    jobRoleService.getJobRoleById(id)).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        } catch (DoesNotExistException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).build();
        }
    }
}
