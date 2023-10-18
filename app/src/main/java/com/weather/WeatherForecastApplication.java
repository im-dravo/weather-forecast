package com.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class WeatherForecastApplication {

    public static void main(String[] args) {
    	Environment env = SpringApplication.run(WeatherForecastApplication.class, args).getEnvironment();
        log.info("Application started on " + env.getProperty("server.port"));
    }
}
