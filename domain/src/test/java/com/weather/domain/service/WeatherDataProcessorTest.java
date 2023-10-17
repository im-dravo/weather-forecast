package com.weather.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.weather.domain.model.Weather;
import com.weather.domain.model.WeatherResponse;

class WeatherDataProcessorTest {
	
	@Test
    void testGetWarmestDay() {
        // given
		WeatherDataProcessor dataProcessor = new WeatherDataProcessor();
		WeatherResponse mockWeatherResponse = new WeatherResponse();
		ArrayList<Weather> weatherList = new ArrayList<>();
		weatherList.add(new Weather(304.42, 18, "2023-10-14 15:00:00"));
		weatherList.add(new Weather(303.42, 19, "2023-10-15 15:00:00"));
		mockWeatherResponse.setWeatherList(weatherList);
		

        // and when
		Optional<String> result = dataProcessor.getWarmestDay(mockWeatherResponse);

        // then
		assertEquals(result.get(), "2023-10-14");
    }
	
	@Test
    void testGetWarmestDayWithEqualTemperatures() {
        // given
		WeatherDataProcessor dataProcessor = new WeatherDataProcessor();
		WeatherResponse mockWeatherResponse = new WeatherResponse();
		ArrayList<Weather> weatherList = new ArrayList<>();
		weatherList.add(new Weather(302.42, 18, "2023-10-14 15:00:00"));
		weatherList.add(new Weather(303.42, 19, "2023-10-15 15:00:00"));
		weatherList.add(new Weather(303.42, 18, "2023-10-16 15:00:00"));
		mockWeatherResponse.setWeatherList(weatherList);
		

        // and when
		Optional<String> result = dataProcessor.getWarmestDay(mockWeatherResponse);

        // then
		assertEquals(result.get(), "2023-10-16");
    }
}
