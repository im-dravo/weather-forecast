package com.weather.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
