package com.weather.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.weather.api.model.GetWarmestDayResponse;
import com.weather.api.model.GetWeatherRequestHistoryResponse;
import com.weather.domain.entity.WeatherRequestHistory;
import com.weather.domain.model.WeatherResponse;
import com.weather.domain.repository.WeatherRequestHistoryRepository;
import com.weather.domain.service.WeatherDataProcessor;
import com.weather.domain.service.WeatherProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {

	@Autowired
	private WeatherProvider weatherProvider;

	@Autowired
	private WeatherDataProcessor weatherDataProcessor;

	@Autowired
	private WeatherRequestHistoryRepository weatherRequestHistoryRepository;

	@Transactional
	public GetWarmestDayResponse retrieveWeather(BigDecimal latitude, BigDecimal longitude, UUID userId) {
		WeatherResponse weatherResponse = weatherProvider.retrieveWeather(latitude, longitude);
		Optional<String> warmestDay = weatherDataProcessor.getWarmestDay(weatherResponse);
		if (warmestDay.isPresent()) {
			this.saveWeatherRequestHistory(new WeatherRequestHistory(userId, weatherResponse.getResultCount(), latitude,
					longitude, warmestDay.get()));
			return new GetWarmestDayResponse(warmestDay.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Weather not found");
		}

	}

	@Transactional
	public WeatherRequestHistory saveWeatherRequestHistory(WeatherRequestHistory weatherRequestHistory) {
		return weatherRequestHistoryRepository.save(weatherRequestHistory);
	}

	@Transactional(readOnly = true)
	public GetWeatherRequestHistoryResponse findByUserId(UUID userId, String orderingField) {
		List<WeatherRequestHistory> weatherHistory = weatherRequestHistoryRepository.findByUserId(userId,
				orderingField);
		if (weatherHistory.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No history found for requested user.");
		}
		return new GetWeatherRequestHistoryResponse(weatherHistory);
	}
}