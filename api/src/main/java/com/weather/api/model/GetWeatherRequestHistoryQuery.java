package com.weather.api.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetWeatherRequestHistoryQuery {
	public enum ORDER_FIELD {
	    WEATHER_HISTORY_REQUESTED_DATE, WEATHER_RESULT_COUNT;
	}
	
	@Enumerated()
	@Nullable
	private ORDER_FIELD orderBy;

	public ORDER_FIELD getOrderBy() {
		return orderBy;
	}

	public void setOrderField(ORDER_FIELD orderBy) {
		this.orderBy = orderBy;
	}
	
	public String customOrderByField() {
		if(this.orderBy == null) { 
			return "requestedOn";
		} 
		return "resultCount";
	}
}
