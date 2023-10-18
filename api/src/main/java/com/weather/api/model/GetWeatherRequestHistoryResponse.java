package com.weather.api.model;

import java.util.List;

import com.weather.domain.entity.WeatherRequestHistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetWeatherRequestHistoryResponse{
	public enum ORDER_FIELD {
	    REQUESTED_ON, RESULT_COUNT;
	}

	private List<WeatherRequestHistory> history;
}
