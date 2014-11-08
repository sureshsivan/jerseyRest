package com.suren.learn;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by suren on 6/11/14.
 */
@LogRequest
@Provider
public class LogRequestFilter implements ContainerRequestFilter{


    /**
     * @param containerRequestContext
     * @throws java.io.IOException
     */
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

    }


}
