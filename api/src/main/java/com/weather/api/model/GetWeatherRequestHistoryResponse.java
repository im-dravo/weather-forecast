package com.weather.api.model;

import java.util.List;

import com.weather.domain.entity.WeatherRequestHistory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetWeatherRequestHistoryResponse{
	public GetWeatherRequestHistoryResponse(List<WeatherRequestHistory> history) {
		super();
		this.history = history;
	}

	private List<WeatherRequestHistory> history;

	public List<WeatherRequestHistory> getHistory() {
		return history;
	}

	public void setHistory(List<WeatherRequestHistory> history) {
		this.history = history;
	}
}
