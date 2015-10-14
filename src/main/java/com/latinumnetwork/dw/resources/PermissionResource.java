/**
 * 
 */
package com.latinumnetwork.dw.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author aht
 * @created Oct 14, 2015
 *
 */
@Path("/permissions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PermissionResource {

    @GET
    @Path("/subject")
    public String passingLists() {

        Subject s = SecurityUtils.getSubject();
        Map<String, Object> map = new HashMap<>();
        map.put("authenticated", s.isAuthenticated());
        map.put("principal", s.getPrincipal());
        map.put("session", s.getSession());

        return map.toString();

    }

    @GET
    @Path("/isLoggedIn")
    public String isLoggedIn() {
        final Subject s = SecurityUtils.getSubject();
        if (s != null && s.isAuthenticated()) {
            return String.format("Logged in as '%s'.", s.getPrincipal());
        } else {
            return "Not logged in.";
        }
    }
}
