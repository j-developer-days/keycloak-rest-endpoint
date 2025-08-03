package com.jdev;

import com.jdev.endpoint.CustomEndpointResource;
import org.jboss.logging.Logger;
import org.keycloak.services.resource.RealmResourceProvider;

public class CustomRealmResourceProvider implements RealmResourceProvider {

    private static final Logger logger = Logger.getLogger(CustomRealmResourceProvider.class);

    @Override
    public Object getResource() {
        logger.info("CUSTOM CustomRealmResourceProvider.getResource");
        return new CustomEndpointResource();
    }


    @Override
    public void close() {
        logger.info("CUSTOM CustomRealmResourceProvider.close");
    }
}
