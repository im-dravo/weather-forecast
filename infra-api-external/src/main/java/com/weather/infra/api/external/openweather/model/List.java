package com.weather.infra.api.external.openweather.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
