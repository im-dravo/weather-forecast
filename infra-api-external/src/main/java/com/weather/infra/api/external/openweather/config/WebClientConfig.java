package com.weather.infra.api.external.openweather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

	@Bean
	public WebClient webClient() {
	// TODO - Take openweather base URL from env config
	  return WebClient.builder().baseUrl("https://api.openweathermap.org").build();
	}
}
