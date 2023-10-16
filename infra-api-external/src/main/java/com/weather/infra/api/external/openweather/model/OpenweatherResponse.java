package com.weather.infra.api.external.openweather.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenweatherResponse{
	private String cod;
	private int message;
	private int cnt;
	private ArrayList<List> list;
	private City city;
}
