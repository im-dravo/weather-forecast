package com.weather.domain.entity;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;

@Entity
public class WeatherRequestHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter(AccessLevel.PRIVATE)
	private Long id;

	@Column(name = "USER_ID", length = 20, nullable = false, unique = false)
	private UUID userId;

	@Getter(AccessLevel.PUBLIC)
	private Double latitude;

	@Getter(AccessLevel.PUBLIC)
	private Double longitude;

	@Getter(AccessLevel.PUBLIC)
	private int resultsCount;

	@Getter(AccessLevel.PUBLIC)
	private String warmestDayIdentified;

	@CreationTimestamp
	@Getter(AccessLevel.PUBLIC)
	private Instant requestedOn;

	// for JPA only, no use
	public WeatherRequestHistory() {
	}

	public WeatherRequestHistory(UUID userId, Double latitude, Double longitude, int resultsCount,
			String warmestDayIdentified) {
		this.userId = userId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.resultsCount = resultsCount;
		this.warmestDayIdentified = warmestDayIdentified;
	}
}
