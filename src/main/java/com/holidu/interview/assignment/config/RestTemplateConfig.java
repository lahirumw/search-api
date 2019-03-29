package com.holidu.interview.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * Provide Rest Template Bean
 * 
 * @author lahirua
 *
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
	
	return new RestTemplate();
    }
}
