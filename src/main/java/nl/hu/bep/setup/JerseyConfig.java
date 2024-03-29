package nl.hu.bep.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restservices")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("nl.hu.bep.battlesnake.webservices","nl.hu.bep.battlesnake.security");
        register(RolesAllowedDynamicFeature.class);
    }
}
