package com.jdev;

import com.jdev.endpoint.CustomEndpointResource;
import org.jboss.logging.Logger;
import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.services.resource.RealmResourceProviderFactory;

public class CustomRealmResourceProviderFactory implements RealmResourceProviderFactory {

    private static final Logger logger = Logger.getLogger(CustomRealmResourceProviderFactory.class);

    public static final String PROVIDER_ID = "custom-endpoint";

    @Override
    public RealmResourceProvider create(KeycloakSession session) {
        return new CustomEndpointResource(session);
    }

    @Override
    public void init(Config.Scope config) {
        logger.info("CustomRealmResourceProviderFactory.init -----");
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
        logger.info("CustomRealmResourceProviderFactory.postInit -----");
    }

    @Override
    public void close() {
        logger.info("CustomRealmResourceProviderFactory.close -----");
    }

    //https://www.keycloak.org/server/configuration-provider
    //spi-<spi-id>-<provider-id>-<property>=<value>
    //spi-realm-restapi-extension-custom-endpoint-enabled=true
    //spi-admin-realm-restapi-extension-custom-endpoint-enabled=true
    @Override
    public String getId() {
        logger.info("CustomRealmResourceProviderFactory.getId ----- PROVIDER_ID - " + PROVIDER_ID);
        return PROVIDER_ID;
    }
}
