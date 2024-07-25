package org.example.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.example.TestApplication;
import org.example.TestConfiguration;
import org.example.models.OpenJobRoleResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import javax.ws.rs.client.Client;
import java.util.List;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRoleControllerIntegrationTest {
    private static final DropwizardAppExtension<TestConfiguration> APP =
            new DropwizardAppExtension<>(TestApplication.class);
    /*
    when calling getJobRoles
    expect list of JobRoleResponses
     */
    @Test
    void getJobRoles_shouldReturnListOfJobRoles() {
        Client client = APP.client();

        List<OpenJobRoleResponse> response = client
                .target("http://localhost:8080/api/openJobRoles")
                .request()
                .get(List.class);

        Assertions.assertFalse(response.isEmpty());
    }
}
