package com.weather.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Coordinates {
	private double latitude;
	private double longitude;
	
	public Coordinates(double d, double e) {
		super();
		this.latitude = d;
		this.longitude = e;
	}
}
