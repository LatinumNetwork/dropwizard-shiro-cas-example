/**
 * 
 */
package com.latinumnetwork.dw.config;

import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * @author aht
 * @created Oct 14, 2015
 *
 */
public class ShiroConfiguration extends Configuration {

    @JsonProperty("secured_url_pattern")
    private String securedUrlPattern = "/*";

    public String getSecuredUrlPattern() {
        return securedUrlPattern;
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this.getClass().getSimpleName())
                .add("securedUrlPattern (secured_url_pattern)", securedUrlPattern);

    }
}
