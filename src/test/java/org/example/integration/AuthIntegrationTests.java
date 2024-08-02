package org.example.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;

import org.example.TestApplication;
import org.example.TestConfiguration;
import org.example.models.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.Base64;

@ExtendWith(DropwizardExtensionsSupport.class)
public class AuthIntegrationTests {
    String USERNAME = System.getenv().get("LOGIN_USER");
    String PASSWORD = System.getenv().get("LOGIN_PASS");

    public static final DropwizardAppExtension<TestConfiguration> APP =
            new DropwizardAppExtension<>(TestApplication.class);

    @Test
    void login_shouldLogin_whenCorrectCredentials(){
        Client client = APP.client();
        LoginRequest login = new LoginRequest(USERNAME, PASSWORD);

        Response response = client.target
                ("http://localhost:8080/api/auth/login").request()
                .post(Entity.json(login));

        Assertions.assertEquals(200, response.getStatus());

        String[] respChunks = response.readEntity(String.class).split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String body = new String(decoder.decode(respChunks[1]));

        Assertions.assertTrue(body.contains("\"Role\":1")
                && body.contains("\"sub\":\"admin\"")
                && body.contains("\"iss\":\"team1-api\""));
    }

    @Test
    void login_shouldThrowInvalidException_whenIncorrectCredentials(){
        Client client = APP.client();
        LoginRequest login = new LoginRequest(USERNAME, "invalidpassword1234");

        Response response = client.target
                        ("http://localhost:8080/api/auth/login").request()
                .post(Entity.json(login));

        Assertions.assertEquals(400, response.getStatus());
    }
}
