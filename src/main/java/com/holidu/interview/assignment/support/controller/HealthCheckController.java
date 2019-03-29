package com.holidu.interview.assignment.support.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping(name = "healthCheckEndpoint", value = "/")
    public String healthCheck() {
	return "Greetings from the Holidu interview assignment!";
    }

}
