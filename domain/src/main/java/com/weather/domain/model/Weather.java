package com.weather.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather{
	public Weather(double maximumTemperature, int humidity, String dateTime) {
		super();
		this.maximumTemperature = maximumTemperature;
		this.humidity = humidity;
		this.dateTime = dateTime;
	}

	private double maximumTemperature;
	private int humidity;
	private String dateTime;
}
