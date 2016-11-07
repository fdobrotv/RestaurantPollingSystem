package com.fdobrotv.rps.common.controller.jersey.config;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Fedor Dobrotvorsky on 02.11.2016.
 */
import com.fdobrotv.rps.common.controller.jersey.controllers.*;
import com.fdobrotv.rps.common.controller.jersey.controllers.support.HealthController;
import org.glassfish.jersey.server.ResourceConfig;
//import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Profile("web")
@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HealthController.class);
        register(UserController.class);
        register(RestaurantController.class);
        register(VoteController.class);
        register(MenuController.class);
    }
}
