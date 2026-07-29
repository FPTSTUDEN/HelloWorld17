package maria.controller;

import maria.dao.CurrencyDao;
import maria.entity.Currency;

import java.sql.SQLException;

public class ConverterController {
    private final CurrencyDao currencyDao;
    
    public ConverterController() {
        this.currencyDao = new CurrencyDao();
    }
    
    /**
     * Converts an amount from source currency to target currency
     * @param amount The amount to convert
     * @param source The source currency
     * @param target The target currency
     * @return The converted amount
     * @throws SQLException if database error occurs
     */
    public double convert(double amount, Currency source, Currency target) throws SQLException {
        // Get exchange rates from database
        double sourceRate = currencyDao.getRateByAbbreviation(source.getCode());
        double targetRate = currencyDao.getRateByAbbreviation(target.getCode());
        
        return amount * (targetRate / sourceRate);
    }
    
    /**
     * Retrieves all currencies from the database
     * @return List of all currencies
     * @throws SQLException if database error occurs
     */
    public java.util.List<Currency> getAllCurrencies() throws SQLException {
        return currencyDao.getAllCurrencies();
    }
}