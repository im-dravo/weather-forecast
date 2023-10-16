package com.weather.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;

import com.weather.domain.entity.WeatherRequestHistory;

public interface WeatherRequestHistoryRepository {	
	WeatherRequestHistory save(WeatherRequestHistory weatherRequestHistory);
	
	@Query("SELECT wh FROM WeatherRequestHistory wh WHERE wh.userId = :userId ORDER BY :orderingField DESC")
	List<WeatherRequestHistory> findByUserId(UUID userId, String orderingField);
}