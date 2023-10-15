package com.weather.domain.repository;

import java.util.List;
import java.util.UUID;

import com.weather.domain.entity.WeatherRequestHistory;

public interface WeatherRequestHistoryRepository {	
	WeatherRequestHistory save(WeatherRequestHistory weatherRequestHistory);
	
	List<WeatherRequestHistory> findByUserId(UUID userId);
}