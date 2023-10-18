package com.weather.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetWarmestDayResponse {
	private String warmestDay;

	public String getWarmestDay() {
		return warmestDay;
	}

	public void setWarmestDay(String warmestDay) {
		this.warmestDay = warmestDay;
	}
}
