package com.weather.infra.api.external.openweather.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Wind{
	public double speed;
	public int deg;
    public double gust;
}
