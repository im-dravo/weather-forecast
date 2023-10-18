package com.weather.infra.api.external.openweather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
