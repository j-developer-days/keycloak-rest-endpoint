package com.jdev;

import com.jdev.endpoint.CustomEndpointResource;
import org.jboss.resteasy.util.GetRestful;

public class MainCheck {

    public static void main(String[] args) {
        System.out.println(!GetRestful.isSubResourceClass(CustomEndpointResource.class));
    }
}
