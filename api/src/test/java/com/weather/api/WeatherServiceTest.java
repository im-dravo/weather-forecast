package com.weather.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.weather.api.model.GetWarmestDayResponse;
import com.weather.domain.entity.WeatherRequestHistory;
import com.weather.domain.model.WeatherResponse;
import com.weather.domain.repository.WeatherRequestHistoryRepository;
import com.weather.domain.service.WeatherDataProcessor;
import com.weather.domain.service.WeatherProvider;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

	@Mock
    private WeatherProvider weatherProvider;
    
    @Mock
    private WeatherDataProcessor weatherDataProcessor;
    
    @Mock
    private WeatherRequestHistoryRepository weatherRequestHistoryRepository;

    @Autowired
    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
    	weatherService = new WeatherService(weatherProvider, weatherDataProcessor, weatherRequestHistoryRepository);
    }

    //@Test
    void retrieveWeather() {
    	String mockDate = "2023-10-10";
    	// Given
    	WeatherResponse weatherResponse = new WeatherResponse();
    	when(weatherProvider.retrieveWeather(any(), any())).thenReturn(weatherResponse);
    	when(weatherDataProcessor.getWarmestDay(any())).thenReturn(Optional.of(mockDate));
    	when(weatherRequestHistoryRepository.save(any())).thenReturn(new WeatherRequestHistory());
        BigDecimal latitude = new BigDecimal(50.222222);
        BigDecimal longitude = new BigDecimal(30.222222);
        UUID userId = UUID.fromString("4ed1318b-ddc0-4a87-8331-e93eb3871392");
        
        // When
        GetWarmestDayResponse warmestDayResponse = weatherService.retrieveWeather(
        		latitude, longitude, userId	
        );

        // Then
        assertEquals(warmestDayResponse.getWarmestDay(), "2023-10-10");
        verify(weatherProvider, times(1)).retrieveWeather(any(), any());
        verify(weatherDataProcessor, times(1)).getWarmestDay(any());
        verify(weatherRequestHistoryRepository, times(1)).save(any());
    }
    //TODO: Debug the tests

   
}