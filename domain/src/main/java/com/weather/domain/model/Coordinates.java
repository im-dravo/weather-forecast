package com.weather.domain.model;

import lombok.ToString;

@ToString
public class Coordinates {
	private double latitude;
	private double longitude;
	
	public Coordinates(double d, double e) {
		super();
		this.latitude = d;
		this.longitude = e;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
