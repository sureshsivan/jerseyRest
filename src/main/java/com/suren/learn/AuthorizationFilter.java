package com.suren.learn;

import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.internal.routing.UriRoutingContext;
import org.glassfish.jersey.server.model.ResourceMethodInvoker;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by suren on 6/11/14.
 */
@Authorize
@Provider
public class AuthorizationFilter implements ContainerRequestFilter, ContainerResponseFilter{


    /**
     * Authenticate using header available token or body params (username and password)
     * If Authentication fails return with HTML Error code
     * If Authentication succeeds - add it into token cache
     * @param containerRequestContext
     * @throws java.io.IOException
     */
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Request Filter : Authorization");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if(containerRequestContext instanceof ContainerRequest) {
            ContainerRequest containerRequest = (ContainerRequest) containerRequestContext;
            Method method = containerRequest.getUriInfo().getMatchedResourceMethod().getInvocable().getHandlingMethod();
            Authorize authorize = method.getAnnotation(Authorize.class);
            //  Check for Class Level Authorization Annotation marker
            if(authorize == null){
                authorize = containerRequest.getUriInfo().getMatchedResourceMethod().getInvocable().getHandler().getHandlerClass().getAnnotation(Authorize.class);
            }
            System.out.println(authorize.value());
        }

//        Response authenticationRequired = Response.status(Response.Status.PROXY_AUTHENTICATION_REQUIRED).build();
        Response unAuthorised = Response.status(Response.Status.UNAUTHORIZED).build();

        containerRequestContext.abortWith(unAuthorised);
    }


    /**
     * Add a Auth token header whenever sending a response
     * If the token is going to expire - then create new token and update token cache/DB
     *
     * @param containerRequestContext
     * @param containerResponseContext
     * @throws java.io.IOException
     */
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Response Filter : Authorization");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
