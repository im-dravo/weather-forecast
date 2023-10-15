package com.weather.infra.api.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.api.WeatherService;
import com.weather.domain.entity.WeatherRequestHistory;

@RestController
@RequestMapping("/weather-request-history")
public class WeatherRequestHistoryController {

	@Autowired
    private WeatherService weatherService;

    @GetMapping("/user/{id}")
    public List<WeatherRequestHistory> findHistoryByUserId(@PathVariable UUID id) {
        return weatherService.findByUserId(id);
    }
}
