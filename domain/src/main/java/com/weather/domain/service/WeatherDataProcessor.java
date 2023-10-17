package com.weather.domain.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.weather.domain.model.Weather;
import com.weather.domain.model.WeatherResponse;

@Service
public class WeatherDataProcessor {
	private static final String DATE_SEPERATOR = " ";
	
	public Optional<String> getWarmestDay(WeatherResponse weatherResponse) {
		ArrayList<Weather> weatherList = weatherResponse.getWeatherList();
		List<Weather> weatherListOrderedByDateAndHumidity = weatherList.stream()
				.sorted(Comparator.comparing(Weather::getMaximumTemperature).reversed().thenComparingInt(Weather::getHumidity))
				.collect(Collectors.toList());
		
		if(weatherListOrderedByDateAndHumidity.isEmpty()) {
			return Optional.empty();
		}
		
		Optional<String> warmestDateTime = Optional.ofNullable(weatherListOrderedByDateAndHumidity.get(0).getDateTime());
		return warmestDateTime.map(dateTime -> getDate(dateTime));
	}
	
	private String getDate(String datetime) {
		return datetime.split(DATE_SEPERATOR)[0];
	}
}
