package maria.dao;

import maria.entity.Currency;
import maria.datasource.MariaDbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {
    
    /**
     * Retrieves the exchange rate for a given currency abbreviation
     * @param abbreviation The currency abbreviation (e.g., "USD", "EUR")
     * @return The exchange rate to USD
     * @throws SQLException if database error occurs
     */
    public double getRateByAbbreviation(String abbreviation) throws SQLException {
        String sql = "SELECT rate_to_usd FROM Currency WHERE abbreviation = ?";
        
        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, abbreviation);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("rate_to_usd");
                } else {
                    throw new SQLException("Currency not found: " + abbreviation);
                }
            }
        }
    }
    
    /**
     * Retrieves a complete Currency object by abbreviation
     * @param abbreviation The currency abbreviation
     * @return Currency object or null if not found
     * @throws SQLException if database error occurs
     */
    public Currency getCurrencyByAbbreviation(String abbreviation) throws SQLException {
        String sql = "SELECT id, abbreviation, name, rate_to_usd FROM Currency WHERE abbreviation = ?";
        // try (cond) {command} automatically closes the connection and statement after execution
        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, abbreviation);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Currency(
                        rs.getInt("id"),
                        rs.getString("abbreviation"),
                        rs.getString("name"),
                        rs.getDouble("rate_to_usd")
                    );
                }
                return null;
            }
        }
    }
    
    /**
     * Retrieves all currencies from the database
     * @return List of all Currency objects
     * @throws SQLException if database error occurs
     */
    public List<Currency> getAllCurrencies() throws SQLException {
        List<Currency> currencies = new ArrayList<>();
        String sql = "SELECT id, abbreviation, name, rate_to_usd FROM Currency ORDER BY abbreviation";
        
        try (Connection conn = MariaDbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Currency currency = new Currency(
                    rs.getInt("id"),
                    rs.getString("abbreviation"),
                    rs.getString("name"),
                    rs.getDouble("rate_to_usd")
                );
                currencies.add(currency);
            }
        }
        return currencies;
    }
}