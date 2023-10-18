package com.weather.infra.api.external.openweather.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class List{
	private int dt;
	private Main main;
	private ArrayList<Weather> weather;
	private Clouds clouds;
	private Wind wind;
	private int visibility;
	private int pop;
	private Sys sys;
	private String dt_txt;
}
