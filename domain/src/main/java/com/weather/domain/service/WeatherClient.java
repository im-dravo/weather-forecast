package com.weather.domain.service;

import com.weather.domain.model.WeatherResponse;

public interface WeatherClient {
	WeatherResponse retrieveWeather(Double latitude, Double longitude);
}