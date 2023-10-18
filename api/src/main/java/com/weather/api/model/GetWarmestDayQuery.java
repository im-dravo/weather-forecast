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
	@NotNull
	@DecimalMin(value = "50.10319", inclusive = true, message = "Invalid latitude. Only allowed to access weather for UK coordinates")
	@DecimalMax(value = "60.15456", inclusive = true, message = "Invalid latitude. Only allowed to access weather for UK coordinates")
	@Digits(integer=2, fraction=6)
	private Double latitude;

	@NotNull
	@DecimalMin(value = "-7.64133", inclusive = true, message = "Invalid longitude. Only allowed to access weather for UK coordinates")
	@DecimalMax(value = "1.75159", inclusive = true, message = "Invalid longitude. Only allowed to access weather for UK coordinates")
	@Digits(integer=2, fraction=6)
	private Double longitude;
	
	@NotNull
	private UUID userId;
}
