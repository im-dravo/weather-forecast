package com.weather.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
	private double maximumTemperature;
	private int humidity;
	private String dateTime;
}
