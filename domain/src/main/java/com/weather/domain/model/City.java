package com.weather.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City{
	private String cityName;
    private Coordinates coordinates;
    private String country;
}
