package de.currency.exchanger.klt.exceptions;

import lombok.Builder;
import lombok.Data;

/**
 * @author Radhouene Rouached
 */
@Data
@Builder
public class CurrencyException extends Exception {
    private String errorMessage;

    public CurrencyException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}