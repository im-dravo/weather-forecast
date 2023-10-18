package com.weather.infra.api.external.openweather.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenweatherResponse{
	private String cod;
	private int message;
	private int cnt;
	private ArrayList<List> list;
	private City city;
}
