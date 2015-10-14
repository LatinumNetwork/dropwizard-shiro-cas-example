/**
 * 
 */
package com.latinumnetwork.dw.filters;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.IniFactorySupport;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * @author aht
 * @created Oct 14, 2015
 *
 */
public class ApiFilter extends AuthenticatingFilter {

    private static final Log LOG = LogFactory.getLog(ApiFilter.class);

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.shiro.web.filter.authc.AuthenticatingFilter#createToken(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        LOG.info("onAccessDenied was called from the ApiFilter");
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.shiro.web.filter.AccessControlFilter#onAccessDenied(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        LOG.debug("onAccessDenied was called from the ApiFilter");

        Ini ini = IniFactorySupport.loadDefaultClassPathIni();

        if (ini == null) {
            throw new Exception("Required configuration properties are missing");
        }

        WebUtils.issueRedirect(request, response, ini.getSectionProperty("main", "roles.loginUrl"));

        return false;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        boolean isAccessAllowed = super.isAccessAllowed(request, response, mappedValue);
        LOG.debug("isAccessAllowed was called from the ApiFilter isAccessAllowed[" + isAccessAllowed + "]");

        return isAccessAllowed;
    }

}
