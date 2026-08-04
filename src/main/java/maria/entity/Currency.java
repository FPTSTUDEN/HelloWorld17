package maria.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Currency")
public class Currency implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "abbreviation", nullable = false, unique = true, length = 3)
    private String code;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "rate_to_usd", nullable = false)
    private double rateToUSD;

    public Currency() {
        // Default constructor required by JPA
    }

    public Currency(int id, String code, String name, double rateToUSD) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.rateToUSD = rateToUSD;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getRateToUSD() { return rateToUSD; }
    public void setRateToUSD(double rateToUSD) { this.rateToUSD = rateToUSD; }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}