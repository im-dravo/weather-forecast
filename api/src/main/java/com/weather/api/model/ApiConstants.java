package com.weather.api.model;

public class ApiConstants {
	public static enum APP_ERROR_CODES {
	    ERR400, ERR404, ERR500, ERR409;
	}
	
	public static String COORDINATES_OUTSIDE_UK_NI = "";
	
	public static String INVALID_LATITUDE = "Invalid Latitide coordinates. " + COORDINATES_OUTSIDE_UK_NI;
	
	public static String INVALID_LONGITUDE = "Invalid Longitude coordinates. " + COORDINATES_OUTSIDE_UK_NI;
}
