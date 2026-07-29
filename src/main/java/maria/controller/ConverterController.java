package maria.controller;

import maria.entity.Currency;

// Controller: ConverterController.java
public class ConverterController {
    public double convert(double amount, Currency source, Currency target) {
        return amount * (target.getRateToUSD() / source.getRateToUSD());
    }
}
