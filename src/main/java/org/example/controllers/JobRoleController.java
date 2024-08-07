package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.Exceptions.DoesNotExistException;
import org.example.exceptions.DatabaseConnectionException;
import org.example.services.JobRoleService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

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
    /*Returns an ordered list in ascending order by job role name*/
    @GET
    @Path("/{order}/{ByNameAsc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response jobNameAscending() {
        try {
            return Response.ok().entity(
                    jobRoleService.jobNameAscending()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        }
    }

    /*Returns an ordered list in descending order by job role name*/
    @GET
    @Path("/{order}/{ByNameAsc}/{ByNameDesc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response jobNameDescending() {
        try {
            return Response.ok().entity(
                    jobRoleService.jobNameDescending()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        }
    }

    /*Returns an ordered list in Ascending order by job role location*/
    @GET
    @Path("/{order}/{ByNameAsc}/{ByNameDesc}/{ByLocationAsc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response jobLocationAscending() {
        try {
            return Response.ok().entity(
                    jobRoleService.jobLocationAscending()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        }
    }

    /*Returns an ordered list in descending order by job role location*/
    @GET
    @Path("/{order}/{ByNameAsc}/{ByNameDesc}/{ByLocationAsc}/{ByLocationDesc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response jobLocationDescending() {
        try {
            return Response.ok().entity(
                    jobRoleService.jobLocationDescending()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        }
    }

    /*Returns an ordered list in ascending order by job role capability*/
    @GET
    @Path("/{order}/{ByNameAsc}/{ByNameDesc}/{ByLocationAsc}/{ByLocationDesc}"
            + "/{ByCapabilityAsc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response jobCapabilityAscending() {
        try {
            return Response.ok().entity(
                    jobRoleService.jobCapabilityAscending()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        }
    }

    /*Returns an ordered list in descending order by job role capability*/
    @GET
    @Path("/{order}/{ByNameAsc}/{ByNameDesc}/{ByLocationAsc}/{ByLocationDesc}"
            + "/{ByCapabilityAsc}/{ByCapabilityDesc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response jobCapabilityDescending() {
        try {
            return Response.ok().entity(
                    jobRoleService.jobCapabilityDescending()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        }
    }


    /*Returns an ordered list in ascending order by job role band*/
    @GET
    @Path("/{order}/{ByNameAsc}/{ByNameDesc}/{ByLocationAsc}/{ByLocationDesc}"
            + "/{ByCapabilityAsc}/{ByCapabilityDesc}/{ByBandAsc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response jobBandAscending() {
        try {
            return Response.ok().entity(
                    jobRoleService.jobBandAscending()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        }
    }

    /*Returns an ordered list in descending order by job role band*/
    @GET
    @Path("/{order}/{ByNameAsc}/{ByNameDesc}/{ByLocationAsc}/{ByLocationDesc}"
            + "/{ByCapabilityAsc}/{ByCapabilityDesc}/{ByBandAsc}/{ByBandDesc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response jobBandDescending() {
        try {
            return Response.ok().entity(
                    jobRoleService.jobBandDescending()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        }
    }

    /*Returns an ordered list in ascending order by job role closing date*/
    @GET
    @Path("/{order}/{ByNameAsc}/{ByNameDesc}/{ByLocationAsc}/{ByLocationDesc}"
            + "/{ByCapabilityAsc}/{ByCapabilityDesc}/{ByBandAsc}/{ByBandDesc}"
            + "/{ByClosingDateAsc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response jobClosingDateAscending() {
        try {
            return Response.ok().entity(
                    jobRoleService.jobClosingDateAscending()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        }
    }

    /*Returns an ordered list in descending order by job role closing date*/
    @GET
    @Path("/{order}/{ByNameAsc}/{ByNameDesc}/{ByLocationAsc}/{ByLocationDesc}"
            + "/{ByCapabilityAsc}/{ByCapabilityDesc}/{ByBandAsc}/{ByBandDesc}"
            + "/{ByClosingDateAsc}/{ByClosingDateDesc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response jobClosingDateDescending() {
        try {
            return Response.ok().entity(
                    jobRoleService.jobClosingDateDescending()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            return Response.serverError().build();
        }
    }

}
