package com.weather.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.api.model.GetWarmestDayResponse;
import com.weather.domain.entity.WeatherRequestHistory;
import com.weather.domain.model.WeatherResponse;
import com.weather.domain.repository.WeatherRequestHistoryRepository;
import com.weather.domain.service.WeatherDataProcessor;
import com.weather.domain.service.WeatherProvider;

@Service
public class WeatherService {

	@Autowired
	private WeatherProvider weatherProvider;

	@Autowired
	private WeatherDataProcessor weatherDataProcessor;

	@Autowired
	private WeatherRequestHistoryRepository weatherRequestHistoryRepository;

	public GetWarmestDayResponse retrieveWeather(BigDecimal latitude, BigDecimal longitude, UUID userId) {
		WeatherResponse weatherResponse = weatherProvider.retrieveWeather(latitude, longitude);
		String warmestDay = weatherDataProcessor.getWarmestDay(weatherResponse);
		this.saveWeatherRequestHistory(
				new WeatherRequestHistory(userId, weatherResponse.getResultCount(), latitude, longitude, warmestDay));
		return new GetWarmestDayResponse(warmestDay);
	}

	public WeatherRequestHistory saveWeatherRequestHistory(WeatherRequestHistory weatherRequestHistory) {
		return weatherRequestHistoryRepository.save(weatherRequestHistory);
	}

	public List<WeatherRequestHistory> findByUserId(UUID userId) {
		return weatherRequestHistoryRepository.findByUserId(userId);
	}
}