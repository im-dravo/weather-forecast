package com.weather.infra.api.external.openweather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wind{
	public double speed;
	public int deg;
    public double gust;
}
