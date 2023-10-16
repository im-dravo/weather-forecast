package com.weather.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetWarmestDayResponse {
	public GetWarmestDayResponse(String warmestDay) {
		super();
		this.warmestDay = warmestDay;
	}

	private String warmestDay;
}
