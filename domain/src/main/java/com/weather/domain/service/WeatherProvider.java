package com.weather.domain.service;

import java.math.BigDecimal;

import com.weather.domain.model.WeatherResponse;

public interface WeatherProvider {
	WeatherResponse retrieveWeather(BigDecimal latitude, BigDecimal longitude);
}