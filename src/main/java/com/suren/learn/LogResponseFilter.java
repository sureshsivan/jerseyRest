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
@LogRequestResponse
@Provider
public class LogResponseFilter implements ContainerResponseFilter{


    /**
     * @param containerRequestContext
     * @param containerResponseContext
     * @throws java.io.IOException
     */
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {

    }
}
