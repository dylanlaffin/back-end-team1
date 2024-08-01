package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.example.controllers.ApplicationsController;
import org.example.controllers.JobRoleController;
import org.example.daos.ApplicationsDao;
import org.example.daos.JobRoleDao;
import org.example.services.ApplicationsService;
import org.example.services.JobRoleService;
import io.jsonwebtoken.Jwts;
import org.example.controllers.AuthController;
import org.example.daos.AuthDao;
import org.example.services.AuthService;
import java.security.Key;


public class TestApplication extends Application<TestConfiguration> {
    /*
    main method of the TestApplication
     */
    public static void main(final String[] args) throws Exception {
        new TestApplication().run(args);
    }
    @Override
    public String getName() {
        return "Test";
    }
    @Override
    public void initialize(final Bootstrap<TestConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                    final TestConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }
    @Override
    public void run(final TestConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(
                new JobRoleController(new JobRoleService(new JobRoleDao())));
        Key jwtKey = Jwts.SIG.HS256.key().build();
        environment.jersey().register(new AuthController(new AuthService(
                new AuthDao(), jwtKey)));
        environment.jersey().register(new ApplicationsController(
                new ApplicationsService(new ApplicationsDao())));
    }
}
