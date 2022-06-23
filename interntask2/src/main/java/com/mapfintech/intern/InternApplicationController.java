package com.mapfintech.intern;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.logging.Logger;

@RestController
public class InternApplicationController {
    Logger LOGGER = Logger.getLogger(InternApplicationController.class.getName());

    @RequestMapping("/hello-world/{key}")
    public String returnMessage(@PathVariable("key") String message) {
        String output = "Hello " + message + "!";
        LOGGER.info(output);
        return output;
    }

    @RequestMapping("/hello-world")
    public String returnMessage() {
        String output = "Hello world!";
        LOGGER.info(output);
        return output;
    }

}