/**
 * 
 */
package com.latinumnetwork.dw.config;

import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author aht
 * @created Oct 14, 2015
 *
 */
public class ExampleConfiguration extends Configuration {
    @NotNull
    @Valid
    @JsonProperty("shiro_configuration")
    private ShiroConfiguration shiroConfig = new ShiroConfiguration();
    
    public ShiroConfiguration getShiroConfiguration() {
        return shiroConfig;
    }
}
