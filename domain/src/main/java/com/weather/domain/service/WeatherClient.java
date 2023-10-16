package com.weather.domain.service;

import java.math.BigDecimal;

import com.weather.domain.model.WeatherResponse;

public interface WeatherClient {
	WeatherResponse retrieveWeather(BigDecimal latitude, BigDecimal longitude);
}