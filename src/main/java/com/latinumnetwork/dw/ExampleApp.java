/**
 * 
 */
package com.latinumnetwork.dw;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jersey.errors.EarlyEofExceptionMapper;
import io.dropwizard.jersey.validation.ConstraintViolationExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.common.base.Optional;
import com.latinumnetwork.dw.config.ExampleConfiguration;
import com.latinumnetwork.dw.config.ShiroBundle;
import com.latinumnetwork.dw.config.ShiroConfiguration;
import com.latinumnetwork.dw.resources.PermissionResource;

/**
 * @author aht
 * @created Oct 14, 2015
 *
 */
public class ExampleApp extends Application<ExampleConfiguration> {
    private static final Log LOG = LogFactory.getLog(ExampleApp.class);

    @Override
    public String getName() {
        return "ExampleApp";
    }

    public ExampleApp() {

    }
    
    public static void main(String[] args) throws Exception {
        new ExampleApp().run(args);
    }

    private final ShiroBundle<ExampleConfiguration> shiroBundle = new ShiroBundle<ExampleConfiguration>() {
            @Override 
        public Optional<ShiroConfiguration> getShiroConfiguration(final ExampleConfiguration configuration) {
                return Optional.<ShiroConfiguration>fromNullable(configuration.getShiroConfiguration()); 
            }
        };

    @Override
    public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
        bootstrap.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // Here we specify the location of all the front end files.
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html", "static"));
        bootstrap.addBundle(this.shiroBundle);
    }

    @Override
    public void run(ExampleConfiguration config, Environment environment) throws Exception {

        final PermissionResource permResource = new PermissionResource();

        // Don't forget to register your new resources!
        environment.jersey().register(permResource);

        environment.jersey().register(new ConstraintViolationExceptionMapper());
        environment.jersey().register(new EarlyEofExceptionMapper());

    }
}
