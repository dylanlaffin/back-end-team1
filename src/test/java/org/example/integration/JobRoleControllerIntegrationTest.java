package org.example.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.example.TestApplication;
import org.example.TestConfiguration;
import org.example.models.JobRoleResponse;
import org.example.models.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.List;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRoleControllerIntegrationTest {
    String USERNAME = System.getenv().get("LOGIN_USER");
    String PASSWORD = System.getenv().get("LOGIN_PASS");

    private static final DropwizardAppExtension<TestConfiguration> APP =
            new DropwizardAppExtension<>(TestApplication.class);
    /*
    when calling getJobRoles
    expect list of JobRoleResponses
     */
    @Test
    void getJobRoles_shouldReturnListOfJobRoles() {
        Client client = APP.client();

        LoginRequest login = new LoginRequest(USERNAME, PASSWORD);

        Response token = client.target
                        ("http://localhost:8080/api/auth/login").request()
                .post(Entity.json(login));

        String authHeaderValue = "Bearer " + token.readEntity(String.class);

        List<JobRoleResponse> response = client
                .target("http://localhost:8080/api/openJobRoles")
                .request()
                .get(List.class);

        Assertions.assertFalse(response.isEmpty());
    }

    /*
   when calling getJobRoleById
   expect JobRoleResponse
    */
    @Test
    void getJobRoleById_shouldReturnJobRoleResponse() {
        Client client = APP.client();
        LoginRequest login = new LoginRequest(USERNAME, PASSWORD);

        Response token = client.target
                        ("http://localhost:8080/api/auth/login").request()
                .post(Entity.json(login));

        String authHeaderValue = "Bearer " + token.readEntity(String.class);

      Response response = client
                .target("http://localhost:8080/api/openJobRoles/1")
                .request().header("Authorization", authHeaderValue)
                .get();

        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    void getJobRoles_shouldReturnUnauthorised_whenNotLoggedIn() {
        Client client = APP.client();

        Response response = client
                .target("http://localhost:8080/api/openJobRoles")
                .request()
                .get();

        Assertions.assertEquals(401, response.getStatus());
    }

    @Test
    void getJobRoleById_shouldReturnUnauthorised_whenNotLoggedIn() {
        Client client = APP.client();

        Response response = client
                .target("http://localhost:8080/api/openJobRoles/1")
                .request()
                .get();

        Assertions.assertEquals(401, response.getStatus());
    }

    /*
   when calling getJobRolesByOrder
   expect list of JobRoleResponses in order
    */
    @Test
    void getJobRolesByOrder_shouldReturnListOfJobRolesInOrder() {
        Client client = APP.client();

        //job name in ascending order

        LoginRequest login = new LoginRequest(USERNAME, PASSWORD);

        Response token = client.target
                        ("http://localhost:8080/api/auth/login").request()
                .post(Entity.json(login));

        String authHeaderValue = "Bearer " + token.readEntity(String.class);

        Response response = client
                .target("http://localhost:8080/api/openJobRoles/desc/name")
                .request().header("Authorization", authHeaderValue)
                .get();

        Assertions.assertEquals(200, response.getStatus());


    }
}
