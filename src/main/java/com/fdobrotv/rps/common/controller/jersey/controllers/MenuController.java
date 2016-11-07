package com.fdobrotv.rps.common.controller.jersey.controllers;

/**
 * Created by Fedor Dobrotvorsky on 03.11.2016.
 */

import com.fdobrotv.rps.models.Menu;
import com.fdobrotv.rps.models.repositories.MenuRepository;
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
@Path("/menu")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class MenuController {

    @Inject
    private MenuRepository menuRepository;

    @Context
    private UriInfo uriInfo;

    @GET
    public Page<Menu> findAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("20") int size,
            @QueryParam("sort") @DefaultValue("date") List<String> sort,
            @QueryParam("direction") @DefaultValue("asc") String direction) {

        return menuRepository.findAll(
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
    public Menu findOne(@PathParam("id") Long id) {
        return menuRepository.findOne(id);
    }

    @POST
    public Response save(Menu menu) {

        menu = menuRepository.save(menu);

        URI location = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", menu.getId())
                .build();

        return Response.created(location).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        menuRepository.delete(id);
        return Response.accepted().build();
    }
}