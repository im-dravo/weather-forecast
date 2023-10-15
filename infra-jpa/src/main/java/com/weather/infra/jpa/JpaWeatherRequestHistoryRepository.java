package com.weather.infra.jpa;

import org.springframework.data.repository.CrudRepository;

import com.weather.domain.entity.WeatherRequestHistory;
import com.weather.domain.repository.WeatherRequestHistoryRepository;

public interface JpaWeatherRequestHistoryRepository extends CrudRepository<WeatherRequestHistory, Long>, WeatherRequestHistoryRepository {
}
