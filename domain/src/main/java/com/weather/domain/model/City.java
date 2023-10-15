package com.weather.domain.model;

import lombok.ToString;

@ToString
public class City{
	private String cityName;
    private Coordinates coordinates;
    private String country;
    
    public City(String cityName, Coordinates coordinates, String country) {
		super();
		this.cityName = cityName;
		this.coordinates = coordinates;
		this.country = country;
	}
    
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
