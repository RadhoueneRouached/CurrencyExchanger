package de.currency.exchanger.klt.rest;

import de.currency.exchanger.klt.models.ConverterModel;
import de.currency.exchanger.klt.models.ResponseModel;

public interface ConverterService {
	
	public ResponseModel getConvertedValue(String source, String target, double amount);
	public ConverterModel getConverterModel();

}
