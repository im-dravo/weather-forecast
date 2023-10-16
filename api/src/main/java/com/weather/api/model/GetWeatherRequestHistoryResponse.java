package com.weather.api.model;

import java.util.List;

import com.weather.domain.entity.WeatherRequestHistory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetWeatherRequestHistoryResponse{
	public enum ORDER_FIELD {
	    REQUESTED_ON, RESULT_COUNT;
	}
	
	public GetWeatherRequestHistoryResponse(List<WeatherRequestHistory> history) {
		super();
		this.history = history;
	}

	private List<WeatherRequestHistory> history;
}
