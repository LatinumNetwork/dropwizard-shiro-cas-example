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

    /**
     * Default URL pattern for the ShiroFilter.
     */
    final static String DEFAULT_SECURED_URL_PATTERN = "/*";

    /**
     * Default is {@code false}.
     */
    @JsonProperty
    private boolean enabled = false;

    // could support more than one pattern ...
    /**
     * Default is {@link #DEFAULT_SECURED_URL_PATTERN}.
     */
    @JsonProperty("secured_url_pattern")
    private String securedUrlPattern = DEFAULT_SECURED_URL_PATTERN;

    /**
     * Default is {@code false}.
     */
    @JsonProperty("dropwizard_session_handler")
    private boolean dropwizardSessionHandler = false;

    /**
     * Whether this bundle is enabled.
     * 
     * @return value of the {@code enabled} field. This is {@code false} by default.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Currently supports a single URL-pattern.
     * 
     * @return the ShiroFilter will be configured to intercept URLS matching the returned url pattern.
     */
    public String getSecuredUrlPattern() {
        return securedUrlPattern;
    }

    /**
     * Either this is true, or you've already turned on the Servlet Sessions, or you have enabled Shiro's own "native" session-management
     * mechanism.
     * 
     * @return true if the {@code dropwizard_session_handler} configuration property is true; false otherwise
     */
    public boolean isDropwizardSessionHandler() {
        return dropwizardSessionHandler;
    }

    /**
     * Override Object's {@link Object#toString()} implementation.
     * 
     * @return a String containing the class name and the name:value pairs of the instance's fields.
     */
    @Override
    public String toString() {
        return toStringHelper().toString();
    }

    /**
     * If wishing to add additional fields to the {@link #toString()} return values, subclasses may override this method and call super()
     * and then add their own parts to the result before returing it.
     * 
     * @return an {@link MoreObjects.ToStringHelper} instance populated with the class name and the name:value pairs of the instance's
     *         fields
     */
    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this.getClass().getSimpleName()).add("enabled (enabled)", enabled)
                .add("securedUrlPattern (secured_url_pattern)", securedUrlPattern)
                .add("dropwizardSessionHandler (dropwizard_session_handler)", dropwizardSessionHandler);
    }
}
