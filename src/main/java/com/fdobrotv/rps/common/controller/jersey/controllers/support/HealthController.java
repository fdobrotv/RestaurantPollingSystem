package com.fdobrotv.rps.common.controller.jersey.controllers.support;

/**
 * Created by Fedor Dobrotvorsky on 02.11.2016.
 */

import com.fdobrotv.rps.models.Health;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Component
@Path("/health")
public class HealthController {

    @GET
    @Produces({"application/json"})
    public Health jersey() {
        return new Health("Jersey: Up and Running!");
    }
}
