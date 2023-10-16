package com.weather.infra.api.external.openweather;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.weather.domain.model.City;
import com.weather.domain.model.Coordinates;
import com.weather.domain.model.Weather;
import com.weather.domain.model.WeatherResponse;
import com.weather.domain.service.WeatherProvider;
import com.weather.infra.api.external.openweather.model.List;
import com.weather.infra.api.external.openweather.model.OpenweatherResponse;

public class OpenWeatherClient implements WeatherProvider {

	@Autowired
	private WebClient webClient;

	@Override
	public WeatherResponse retrieveWeather(BigDecimal latitude, BigDecimal longitude) {
		// TODO - Take openweather api from env config
		// TODO - Take API key from env config
		ResponseSpec responseSpec = webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/data/2.5/forecast").queryParam("lat", latitude)
						.queryParam("lon", longitude).queryParam("appid", "3f159511ac64f5393feaa6f3c700c74b").build())
				.retrieve();

		OpenweatherResponse openweatherResponse = responseSpec.bodyToMono(OpenweatherResponse.class).block();

		return this.transformOpenweatherResponse(openweatherResponse);
	}
	

	/**
	 * Method that transforms the Openweather response to domain weather response.
	 * @param openweatherResponse
	 * @return
	 */
	private WeatherResponse transformOpenweatherResponse(OpenweatherResponse openweatherResponse) {
		ArrayList<List> fiveDaysOpenweatherList = openweatherResponse.getList();

		ArrayList<Weather> weatherList = new ArrayList<>();
		fiveDaysOpenweatherList.forEach((weather) -> {
			weatherList.add(new Weather(weather.getMain().getTemp_max(), weather.getMain().getHumidity(), weather.getDt_txt()));
		});

		Coordinates coordinates = new Coordinates(openweatherResponse.getCity().getCoord().getLat(),
				openweatherResponse.getCity().getCoord().getLon());

		City city = new City(openweatherResponse.getCity().getName(), coordinates,
				openweatherResponse.getCity().getCountry());

		WeatherResponse weatherResponse = new WeatherResponse();
		weatherResponse.setWeatherList(weatherList);
		weatherResponse.setCity(city);
		weatherResponse.setResultCount(openweatherResponse.getCnt());
		return weatherResponse;
	}
}