/**
 * 
 */
package com.latinumnetwork.dw.config;

import io.dropwizard.Configuration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.servlet.ShiroFilter;

import com.google.common.base.Optional;

/**
 * @author aht
 * @created Oct 14, 2015
 *
 */
public abstract class ShiroBundle<T extends Configuration> implements ConfiguredBundle<T> {
    private static final Log LOG = LogFactory.getLog(ShiroBundle.class);

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
    }

    public abstract Optional<ShiroConfiguration> getShiroConfiguration(T configuration);

    @Override
    public void run(final T configuration, Environment environment) throws Exception {
        final Optional<ShiroConfiguration> shiroConfig = getShiroConfiguration(configuration);
        if (shiroConfig.isPresent()) {
            LOG.debug("Shiro is configured: [" + shiroConfig + "]");
            initializeShiro(shiroConfig.get(), environment);
        } else {
            LOG.debug("Shiro is not configured");
        }
    }

    private void initializeShiro(final ShiroConfiguration config, Environment environment) {

        environment.servlets().addServletListeners(new EnvironmentLoaderListener());

        final String filterUrlPattern = config.getSecuredUrlPattern();

        environment.servlets().addFilter("shiro-filter", new ShiroFilter())
                .addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, filterUrlPattern);

    }
}
