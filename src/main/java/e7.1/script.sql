-- 1. Drop previous database if exists
DROP DATABASE IF EXISTS currency_converter;

-- 2. Create new database
CREATE DATABASE currency_converter;
USE currency_converter;

-- 3. Create table for Currency objects
CREATE TABLE Currency (
    id INT NOT NULL AUTO_INCREMENT,
    abbreviation VARCHAR(10) NOT NULL,
    name VARCHAR(50) NOT NULL,
    rate_to_usd DECIMAL(12,6) NOT NULL, -- Exchange rate to USD, 12,6 means 12 digits total, 6 after decimal
    PRIMARY KEY (id)
);

-- 4. Populate table with at least 8 currencies
INSERT INTO Currency (abbreviation, name, rate_to_usd) VALUES
('USD', 'US Dollar', 1.000000),
('EUR', 'Euro', 0.920000),
('GBP', 'British Pound', 0.780000),
('JPY', 'Japanese Yen', 155.000000),
-- ('AUD', 'Australian Dollar', 1.500000),
-- ('CAD', 'Canadian Dollar', 1.350000),
-- ('CHF', 'Swiss Franc', 0.880000),
('CNY', 'Chinese Yuan', 7.200000);

-- 5. Drop user account if exists
DROP USER IF EXISTS 'appuser'@'localhost';

-- 6. Create user account
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

-- 7. Grant privileges (only SELECT, INSERT, UPDATE, DELETE)
GRANT SELECT, INSERT, UPDATE, DELETE ON currency_converter.* TO 'appuser'@'localhost';
