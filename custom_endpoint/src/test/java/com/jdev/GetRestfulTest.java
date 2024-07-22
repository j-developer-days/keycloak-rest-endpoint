package com.jdev;

import com.jdev.endpoint.CustomEndpointResource;
import org.jboss.resteasy.util.GetRestful;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetRestfulTest {

    @Test
    void test_GetRestful_isSubResourceClass() {
        final boolean result = !GetRestful.isSubResourceClass(CustomEndpointResource.class);
        System.out.println(result);
        Assertions.assertFalse(result);
    }

}
