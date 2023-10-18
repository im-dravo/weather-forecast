package com.weather.api.model;

import com.weather.api.model.ApiConstants.APP_ERROR_CODES;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
   private String error;
   private String description;
   private APP_ERROR_CODES statusCode;
}