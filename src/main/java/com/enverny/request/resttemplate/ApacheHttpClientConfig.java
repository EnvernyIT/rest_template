package com.enverny.request.resttemplate;

import java.time.Duration;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApacheHttpClientConfig {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	 
	return builder
	.setConnectTimeout(Duration.ofMillis(3000))
	.setReadTimeout(Duration.ofMillis(3000))
	.build();
	}
}
