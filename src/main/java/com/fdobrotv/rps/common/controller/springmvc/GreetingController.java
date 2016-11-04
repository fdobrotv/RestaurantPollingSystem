package com.fdobrotv.rps.common.controller.springmvc;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hi")
    public Greeting greeting(@RequestParam(value="name", defaultValue="my name is RPS! - Restaurant Polling System") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
