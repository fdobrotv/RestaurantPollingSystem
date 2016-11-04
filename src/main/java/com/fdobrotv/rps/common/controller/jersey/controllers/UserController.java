package com.fdobrotv.rps.common.controller.jersey.controllers;

/**
 * Created by Fedor Dobrotvorsky on 03.11.2016.
 */

import com.fdobrotv.rps.models.User;
import com.fdobrotv.rps.models.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

//import org.springframework.context.annotation.Profile;

//@Profile("web")
@Component
@Path("/user")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class UserController {

    @Inject
    private UserRepository userRepository;

    @Context
    private UriInfo uriInfo;

    @GET
    public Page<User> findAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("20") int size,
            @QueryParam("sort") @DefaultValue("login") List<String> sort,
            @QueryParam("direction") @DefaultValue("asc") String direction) {

        return userRepository.findAll(
                new PageRequest(
                        page,
                        size,
                        Sort.Direction.fromString(direction),
                        sort.toArray(new String[0])
                )
        );
    }

    @GET
    @Path("{id}")
    public User findOne(@PathParam("id") Long id) {
        return userRepository.findOne(id);
    }

    @POST
    public Response save(User user) {

        user = userRepository.save(user);

        URI location = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", user.getId())
                .build();

        return Response.created(location).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        userRepository.delete(id);
        return Response.accepted().build();
    }
}