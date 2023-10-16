package com.weather.infra.api.external.openweather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.weather.domain.service.WeatherClient;
import com.weather.infra.api.external.openweather.OpenWeatherClient;

@Configuration
public class WeatherClientConfig {

  @Bean
  WeatherClient weatherClient() {
        return new OpenWeatherClient();
    }
}
