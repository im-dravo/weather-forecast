package com.weather.domain.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse{
	private int resultCount;
    private ArrayList<Weather> weatherList;
    private City city;
}
