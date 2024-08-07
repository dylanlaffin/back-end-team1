package org.example.controllers;
import io.swagger.annotations.Api;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.Order;
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
    instantiates the Job role services
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

    @GET
    @Path("/{order}/{OrderBy}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRolesByOrder(
            @PathParam("order") final String order, @PathParam("OrderBy") String OrderBy) {
            try {
                switch (OrderBy) {
                    case "name":
                        if (order.equals("asc")) {
                            return Response.ok().entity(
                                    jobRoleService.jobNameByAscending()).build();
                        } else if (order.equals("desc")) {
                            return Response.ok().entity(
                                    jobRoleService.jobNameDescending()).build();
                        }
                    case "band":
                        if (order.equals("asc")) {
                            return Response.ok().entity(
                                    jobRoleService.jobBandAscending()).build();
                        } else if (order.equals("desc")) {
                            return Response.ok().entity(
                                    jobRoleService.jobBandDescending()).build();
                        }
                    case "capability":
                        if (order.equals("asc")) {
                            return Response.ok().entity(
                                    jobRoleService.jobCapabilityAscending()).build();
                        } else if (order.equals("desc")) {
                            return Response.ok().entity(
                                    jobRoleService.jobCapabilityDescending()).build();
                        }
                    case "location":
                        if (order.equals("asc")) {
                            return Response.ok().entity(
                                    jobRoleService.jobLocationAscending()).build();
                        } else if (order.equals("desc")) {
                            return Response.ok().entity(
                                    jobRoleService.jobLocationDescending()).build();
                        }
                    case "closing date":
                        if (order.equals("asc")) {
                            return Response.ok().entity(
                                    jobRoleService.jobClosingDateAscending()).build();
                        } else if (order.equals("desc")) {
                            return Response.ok().entity(
                                    jobRoleService.jobClosingDateDescending()).build();
                        }

                    default:
                        throw new IllegalStateException("Unexpected value: " + order);
                }
            } catch (SQLException | DatabaseConnectionException e) {
                return Response.serverError().build();
            }
    }
}
