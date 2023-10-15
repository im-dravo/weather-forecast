package com.weather.domain.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.weather.domain.model.Weather;
import com.weather.domain.model.WeatherResponse;

@Service
public class WeatherDataProcessor {
	public String getWarmestDay(WeatherResponse weatherResponse) {
		ArrayList<Weather> weatherList = weatherResponse.getWeatherList();
		Weather warmestWeather = weatherList.stream()
				.sorted(Comparator.comparing(Weather::getMaximumTemperature).thenComparingLong(Weather::getHumidity).reversed())
				.collect(Collectors.toList()).get(0);

		return warmestWeather.getDateTime().split(" ")[0];
		
	}
	
//	TODO
//  return this.formatDate(warmestWeather.getDateTime());
//	private Date formatDate(String dateString) {
//		Date date = null;
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
//		try {
//			date = (Date) formatter.parse(dateString);
//			return date;
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return date;
//	}
}
