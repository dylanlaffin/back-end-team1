package org.example.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.example.TestApplication;
import org.example.TestConfiguration;
import org.example.models.ApplicationRequest;
import org.example.models.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

@ExtendWith(DropwizardExtensionsSupport.class)
public class ApplicationsIntegrationTest {
    String USERNAME = System.getenv().get("LOGIN_USER");
    String PASSWORD = System.getenv().get("LOGIN_PASS");

    private static final DropwizardAppExtension<TestConfiguration> APP =
            new DropwizardAppExtension<>(TestApplication.class);

    @Test
    void addApplication_shouldReturnTrue_whenValidRequestIsMade() {
        Client client = APP.client();

        LoginRequest login = new LoginRequest(USERNAME, PASSWORD);

        Response token = client.target
                        ("http://localhost:8080/api/auth/login").request()
                .post(Entity.json(login));

        String authHeaderValue = "Bearer " + token.readEntity(String.class);

        ApplicationRequest request = new ApplicationRequest(USERNAME, "IN_PROGRESS",
                "testurl.com");

        Response response = client.target("http://localhost:8080/api/applications/add").
                request().header("Authorization", authHeaderValue)
                .post(Entity.json(request));

        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertEquals(true, response.readEntity(Boolean.class));

    }

    @Test
    void addApplication_shouldReturnErrorCode500_whenSQLExceptionThrown() {
        Client client = APP.client();

        LoginRequest login = new LoginRequest(USERNAME, PASSWORD);

        Response token = client.target
                        ("http://localhost:8080/api/auth/login").request()
                .post(Entity.json(login));

        String authHeaderValue = "Bearer " + token.readEntity(String.class);

        ApplicationRequest request = new ApplicationRequest(
                "fakeusernamethatdoesn'texist",
                    "IN_PROGRESS",
            "testurl.com");

        Response response = client.target("http://localhost:8080/api/applications/add").
                request().header("Authorization", authHeaderValue)
                .post(Entity.json(request));

        Assertions.assertEquals(500, response.getStatus());

    }

    @Test
    void addApplication_shouldErrorCode401_whenUserNotLoggedIn() {
        Client client = APP.client();

        ApplicationRequest request = new ApplicationRequest(USERNAME, "IN_PROGRESS",
                "");

        Response response = client.target("http://localhost:8080/api/applications/add").
                request().post(Entity.json(null));

        Assertions.assertEquals(401, response.getStatus());

    }

}
