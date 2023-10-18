package com.weather.infra.api.external.openweather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather{
	public int id;
	public String main;
	public String description;
	public String icon;
}
