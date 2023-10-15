package com.weather.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetWarmestDayResponse {
	public GetWarmestDayResponse(String warmestDay) {
		super();
		this.warmestDay = warmestDay;
	}

	private String warmestDay;

	public String getWarmestDay() {
		return warmestDay;
	}

	public void setWarmestDay(String warmestDay) {
		this.warmestDay = warmestDay;
	}
}
