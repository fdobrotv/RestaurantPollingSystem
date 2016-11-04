package com.fdobrotv.rps.common.controller.jersey.controllers;

/**
 * Created by Fedor Dobrotvorsky on 03.11.2016.
 */

import com.fdobrotv.rps.models.Restaurant;
import com.fdobrotv.rps.models.repositories.RestaurantRepository;
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
@Path("/restaurant")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RestaurantController {

    @Inject
    private RestaurantRepository restaurantRepository;

    @Context
    private UriInfo uriInfo;

    @GET
    public Page<Restaurant> findAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("20") int size,
            @QueryParam("sort") @DefaultValue("name") List<String> sort,
            @QueryParam("direction") @DefaultValue("asc") String direction) {

        return restaurantRepository.findAll(
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
    public Restaurant findOne(@PathParam("id") Long id) {
        return restaurantRepository.findOne(id);
    }

    @POST
    public Response save(Restaurant restaurant) {

        restaurant = restaurantRepository.save(restaurant);

        URI location = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", restaurant.getId())
                .build();

        return Response.created(location).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        restaurantRepository.delete(id);
        return Response.accepted().build();
    }
}