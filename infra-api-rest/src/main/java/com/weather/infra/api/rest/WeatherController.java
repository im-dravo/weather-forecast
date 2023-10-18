package com.weather.infra.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.api.WeatherService;
import com.weather.api.model.GetWarmestDayQuery;
import com.weather.api.model.GetWarmestDayResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@Operation(summary = "Get the warmest day in upcoming 5 days, in the UK region and Northern Ireland only")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "The waremest day is here! Yay!!", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = GetWarmestDayResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid coordinates supplied", content = @Content) })
	@GetMapping("/get-warmest-day")
	public ResponseEntity<GetWarmestDayResponse> getWeather(@Valid GetWarmestDayQuery getWarmestDayRequest) {
		return new ResponseEntity<GetWarmestDayResponse>(
				weatherService.retrieveWeather(getWarmestDayRequest.getLatitude(), getWarmestDayRequest.getLongitude(),
						getWarmestDayRequest.getUserId()),
				HttpStatus.OK);
	}
}
