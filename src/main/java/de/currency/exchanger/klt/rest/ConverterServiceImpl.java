package de.currency.exchanger.klt.rest;

import de.currency.exchanger.klt.models.*;
import de.currency.exchanger.klt.models.Error;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ConverterServiceImpl implements ConverterService {

    @Override
    public ConverterModel getConverterModel() {
        ConverterModel cm = new ConverterModel();
        return cm;
    }

    @Override
    public ResponseModel getConvertedValue(String source, String target, double amount) {
        ResponseModel rm = new ResponseModel();
        rm.setBaseCurrency(source);
        rm.setTargetCurrency(target);
        UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(Constants.API_BASE_URL);
        urlBuilder.queryParam("base", source);
        urlBuilder.queryParam("symbols", target);
        String endPoint = urlBuilder.build().encode().toUriString();
//        System.out.println(endPoint);
        RestTemplate restTemplate = new RestTemplate();
        ConversionRate rates = restTemplate.getForObject(endPoint, ConversionRate.class);

        if (!rates.getRates().isEmpty()) {
            String cRate = rates.getRates().get(target);
            double cVal = Double.valueOf(cRate) * amount;
            rm.setConvertedValue(cVal);
        } else {
            rm.setError(new Error("Unable to convert conrrency", "400"));
            rm.setConvertedValue(Double.MIN_VALUE);
        }

        return rm;

    }
}
