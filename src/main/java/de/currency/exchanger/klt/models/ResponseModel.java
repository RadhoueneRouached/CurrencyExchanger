package de.currency.exchanger.klt.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {
	
	private String baseCurrency;
	private String targetCurrency;
	private double convertedValue;
	private Error error;
}
