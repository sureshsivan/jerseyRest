package com.suren.learn;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by suren on 6/11/14.
 */
@Authenticated
@Provider
public class AuthFilter implements ContainerRequestFilter, ContainerResponseFilter{


    /**
     * Authenticate using header available token or body params (username and password)
     * If Authentication fails return with HTML Error code
     * If Authentication succeeds - add it into token cache
     * @param containerRequestContext
     * @throws IOException
     */
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("#############################");
        System.out.println("Request Filter");
        System.out.println(containerRequestContext.toString());


//        Response authenticationRequired = Response.status(Response.Status.PROXY_AUTHENTICATION_REQUIRED).build();
        Response unAuthorised = Response.status(Response.Status.UNAUTHORIZED).build();

        containerRequestContext.abortWith(unAuthorised);
        System.out.println("#############################");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }


    /**
     * Add a Auth token header whenever sending a response
     * If the token is going to expire - then create new token and update token cache/DB
     *
     * @param containerRequestContext
     * @param containerResponseContext
     * @throws IOException
     */
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Response Filter");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
