package com.weather.infra.api.rest;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.api.WeatherService;
import com.weather.api.model.GetWeatherRequestHistoryQuery;
import com.weather.api.model.GetWeatherRequestHistoryResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/weather-request-history")
public class WeatherRequestHistoryController {

	@Autowired
	private WeatherService weatherService;

	@Operation(summary = "Get a history of their client's calls. By default ordered by requested date. \n "
			+ "The ordering can be explicity requested based on requested date or weather result count")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "History of the user's call to API", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = GetWeatherRequestHistoryResponse.class)) }),
			@ApiResponse(responseCode = "404", description = "No history found", content = @Content) })
	@GetMapping("/user/{userId}")
	public GetWeatherRequestHistoryResponse getHistoryByUserId(@PathVariable UUID userId,
			@Valid GetWeatherRequestHistoryQuery getHistoryQuery) {
		return weatherService.findByUserId(userId, getHistoryQuery.customOrderByField());
	}
}
