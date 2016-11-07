package com.fdobrotv.rps.common.controller.jersey.controllers;

/**
 * Created by Fedor Dobrotvorsky on 05.11.2016.
 */
import com.fdobrotv.rps.common.controller.jersey.service.VoteService;
import com.fdobrotv.rps.models.Menu;
import com.fdobrotv.rps.models.Vote;
import com.fdobrotv.rps.models.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.time.LocalTime;
import java.util.List;

//@RestController
//@RequestMapping(value = "/rest/vote", produces = MediaType.APPLICATION_JSON_VALUE)
@Component
@Path("/vote")
@Produces(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
public class VoteController {
    private static final LocalTime EXPIRED_TIME = LocalTime.parse("11:00");

    @Context
    private UriInfo uriInfo;

    @Inject
    private VoteRepository voteRepository;

    @Autowired
    private VoteService voteService;

    @GET
    public Page<Vote> findAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("20") int size,
            @QueryParam("sort") @DefaultValue("date") List<String> sort,
            @QueryParam("direction") @DefaultValue("asc") String direction) {

        return voteRepository.findAll(
                new PageRequest(
                        page,
                        size,
                        Sort.Direction.fromString(direction),
                        sort.toArray(new String[0])
                )
        );
    }

//    @RequestMapping(method = GET)
//    public ResponseEntity<Restaurant> current() {
//        return voteService.getForUserAndDate(LoggedUser.id(), LocalDate.now())
//                .map(vote -> new ResponseEntity<>(vote.getMenu().getRestaurant(), HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    /**
     * Accepts a user vote for an {@link Menu}
     *
     * @param menu the {@link Menu} user vote for.
     *             Retrieved from the path variable and converted into an {@link Menu} instance by Spring Data's {@link DomainClassConverter}.
     * @return {@link Menu} user voted and code 200 Updated, 201 Created or 409 Conflict
     */

    @POST
    public Response save(Vote vote) {

        vote = voteRepository.save(vote);

        URI location = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", vote.getId())
                .build();

        return Response.created(location).build();
    }

//    @RequestMapping(value = "/{id}", method = POST)
//    public ResponseEntity<Restaurant> vote(@PathVariable("id") Menu menu) {
//        LocalDate today = LocalDate.now();
//        if (menu == null || !menu.getDate().equals(today)) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        Long userId = LoggedUser.id();
//        boolean expired = LocalTime.now().isAfter(EXPIRED_TIME);
//        VoteService.VoteWithStatus voteWithStatus = expired ?
//                voteService.saveIfAbsent(userId, menu) :
//                voteService.save(userId, menu);
//        return new ResponseEntity<>(voteWithStatus.getVote().getMenu().getRestaurant(),
//                voteWithStatus.isCreated() ? HttpStatus.CREATED : (expired ? HttpStatus.CONFLICT : HttpStatus.OK));
//    }
}