package com.weather.api.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetWarmestDayQuery {
	@NotBlank
	@NotNull
	@DecimalMin(value = "50.10319", inclusive = true, message = "Invalid latitude. Only allowed to access weather for UK coordinates")
	@DecimalMax(value = "60.15456", inclusive = true, message = "Invalid latitude. Only allowed to access weather for UK coordinates")
	@Digits(integer=2, fraction=6)
	private BigDecimal latitude;
	
	@NotBlank
	@NotNull
	@DecimalMin(value = "-7.64133", inclusive = true, message = "Invalid longitude. Only allowed to access weather for UK coordinates")
	@DecimalMax(value = "1.75159", inclusive = true, message = "Invalid longitude. Only allowed to access weather for UK coordinates")
	@Digits(integer=2, fraction=6)
	private BigDecimal longitude;
	
	@NotBlank
	@NotNull
	private UUID userId;
}
