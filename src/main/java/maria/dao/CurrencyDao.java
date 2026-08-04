package maria.dao;

import maria.entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class CurrencyDao {
    private static final EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("currencyPU");
    
    /**
     * Retrieves the exchange rate for a given currency abbreviation
     * @param abbreviation The currency abbreviation (e.g., "USD", "EUR")
     * @return The exchange rate to USD
     * @throws jakarta.persistence.PersistenceException if database error occurs
     */
    public double getRateByAbbreviation(String abbreviation) {
        EntityManager em = emf.createEntityManager();
        try {
            // Since we don't have the ID, we still need a query to find by code
            // But we can use a simplified query
            List<Currency> currencies = em.createQuery(
                "SELECT c FROM Currency c WHERE c.code = :code", Currency.class)
                .setParameter("code", abbreviation)
                .getResultList();
            
            if (currencies.isEmpty()) {
                throw new jakarta.persistence.PersistenceException("Currency not found: " + abbreviation);
            }
            return currencies.get(0).getRateToUSD();
        } finally {
            em.close();
        }
    }
    
    /**
     * Retrieves a complete Currency object by abbreviation
     * @param abbreviation The currency abbreviation
     * @return Currency object or null if not found
     * @throws jakarta.persistence.PersistenceException if database error occurs
     */
    public Currency getCurrencyByAbbreviation(String abbreviation) {
        EntityManager em = emf.createEntityManager();
        try {
            // Since we don't have the ID, we still need a query to find by code
            List<Currency> currencies = em.createQuery(
                "SELECT c FROM Currency c WHERE c.code = :code", Currency.class)
                .setParameter("code", abbreviation) // Set the parameter for the query (:code)
                .getResultList();
            
            return currencies.isEmpty() ? null : currencies.get(0);
        } finally {
            em.close();
        }
    }
    
    /**
     * Retrieves a Currency by its ID using em.find()
     * @param id The currency ID
     * @return Currency object or null if not found
     */
    public Currency getCurrencyById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Currency.class, id);
        } finally {
            em.close();
        }
    }
    
    /**
     * Retrieves all currencies from the database
     * @return List of all Currency objects
     * @throws jakarta.persistence.PersistenceException if database error occurs
     */
    public List<Currency> getAllCurrencies() {
        EntityManager em = emf.createEntityManager();
        try {
            // Using JPQL query to get all currencies
            return em.createQuery("SELECT c FROM Currency c ORDER BY c.code", Currency.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
    
    /**
     * Saves a new currency to the database using em.persist()
     * @param currency The currency to save
     * @return The saved currency with generated ID
     */
    public Currency saveCurrency(Currency currency) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(currency);
            em.getTransaction().commit();
            return currency;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new jakarta.persistence.PersistenceException("Error saving currency: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
    
    /**
     * Updates an existing currency using em.merge()
     * @param currency The currency to update
     * @return The updated currency
     */
    public Currency updateCurrency(Currency currency) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Currency updated = em.merge(currency);
            em.getTransaction().commit();
            return updated;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new jakarta.persistence.PersistenceException("Error updating currency: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
    
    /**
     * Deletes a currency from the database using em.remove()
     * @param currency The currency to delete
     */
    public void deleteCurrency(Currency currency) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            // First find the entity to ensure it's managed
            Currency managedCurrency = em.find(Currency.class, currency.getId());
            if (managedCurrency != null) {
                em.remove(managedCurrency);
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
                throw new jakarta.persistence.PersistenceException("Currency not found with ID: " + currency.getId());
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new jakarta.persistence.PersistenceException("Error deleting currency: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
    
    /**
     * Deletes a currency by ID
     * @param id The ID of the currency to delete
     */
    public void deleteCurrencyById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            Currency currency = em.find(Currency.class, id);
            if (currency != null) {
                em.remove(currency);
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
                throw new jakarta.persistence.PersistenceException("Currency not found with ID: " + id);
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new jakarta.persistence.PersistenceException("Error deleting currency: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
    
    /**
     * Closes the EntityManagerFactory
     * Should be called when the application shuts down
     */
    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}