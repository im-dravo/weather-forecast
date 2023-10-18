package com.weather.domain.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse{
	private int resultCount;
    private ArrayList<Weather> weatherList;
    private City city;
}
