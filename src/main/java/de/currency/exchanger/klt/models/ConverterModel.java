package de.currency.exchanger.klt.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConverterModel {

    private String baseCurrency;
    private String targetCurrency;
    private double srcAmount;
    private double targetAmount;
}
