package com.weather.domain.model;

import lombok.ToString;

@ToString
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
	
	public Weather(double maximumTemperature, int humidity) {
		super();
		this.maximumTemperature = maximumTemperature;
		this.humidity = humidity;
	}

	public double getMaximumTemperature() {
		return maximumTemperature;
	}
	public void setMaximumTemperature(double maximumTemperature) {
		this.maximumTemperature = maximumTemperature;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
