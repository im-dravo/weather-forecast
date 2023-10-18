package com.weather.api.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetWeatherRequestHistoryQuery {
	public enum ORDER_FIELD {
	    WEATHER_HISTORY_REQUESTED_DATE, WEATHER_RESULT_COUNT;
	}
	
	@Enumerated()
	@Nullable
	private ORDER_FIELD orderBy;
	
	public String customOrderByField() {
		if(this.orderBy == null) { 
			return "requestedOn";
		} 
		return "resultCount";
	}
}
