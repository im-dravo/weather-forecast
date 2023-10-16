package com.weather.infra.api.external.openweather.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City{
	private int id;
	private String name;
	private Coord coord;
	private String country;
	private int population;
	private int timezone;
	private int sunrise;
	private int sunset;
}
