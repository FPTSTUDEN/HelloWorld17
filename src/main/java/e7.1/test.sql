-- 1. Retrieve all currencies
SELECT * FROM Currency;

-- 2. Retrieve currency with abbreviation EUR
SELECT * FROM Currency WHERE abbreviation = 'EUR';

-- 3. Retrieve number of currencies
SELECT COUNT(*) AS total_currencies FROM Currency;

-- 4. Retrieve currency with highest exchange rate
SELECT * FROM Currency ORDER BY rate_to_usd DESC LIMIT 1;
