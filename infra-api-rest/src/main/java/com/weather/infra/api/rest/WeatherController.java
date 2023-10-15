package com.weather.infra.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.api.WeatherService;
import com.weather.api.model.GetWarmestDayRequest;
import com.weather.api.model.GetWarmestDayResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/get-warmest-day")
    public GetWarmestDayResponse getWeather(@Valid GetWarmestDayRequest getWarmestDayRequest) {
    	return weatherService.retrieveWeather(getWarmestDayRequest.getLatitude(), getWarmestDayRequest.getLongitude(), getWarmestDayRequest.getUserId());
    }
}
