package com.weather.domain.model;

import java.util.ArrayList;

import lombok.ToString;

@ToString
public class WeatherResponse{
	private int resultCount;
    private ArrayList<Weather> weatherList;
    private City city;
    
	public ArrayList<Weather> getWeatherList() {
		return weatherList;
	}
	public void setWeatherList(ArrayList<Weather> weatherList) {
		this.weatherList = weatherList;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public int getResultCount() {
		return resultCount;
	}
	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}
}
