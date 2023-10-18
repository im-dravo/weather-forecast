package com.weather.api.model;

import java.util.UUID;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetWarmestDayQuery {
	@NotNull(message = "Latitude is required")
	@DecimalMin(value = "50.00000", inclusive = true, message = "Invalid latitude. Only allowed to access weather for UK and Norther Ireland")
	@DecimalMax(value = "60.00000", inclusive = true, message = "Invalid latitude. Only allowed to access weather for UK and Norther Ireland")
	@Digits(integer=2, fraction=6, message = "Latitude - Only 6 decimal places are allowed for coordinates")
	private Double latitude;

	@NotNull(message = "Longitude is required")
	@DecimalMin(value = "-10.00000", inclusive = true, message = "Invalid longitude. Only allowed to access weather for UK and Norther Ireland")
	@DecimalMax(value = "2.00000", inclusive = true, message = "Invalid longitude. Only allowed to access weather for UK and Norther Ireland")
	@Digits(integer=2, fraction=6, message = "Longitude - Only 6 decimal places are allowed for coordinates")
	private Double longitude;
	
	@NotNull(message = "UserId is required")
	private UUID userId;
}
