package maria.entity;

// Entity: Currency.java
public class Currency {
    private final int id;
    private final String code;
    private final String name;
    private final double rateToUSD;

    public Currency(int id, String code, String name, double rateToUSD) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.rateToUSD = rateToUSD;
    }

    public int getId() { return id; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public double getRateToUSD() { return rateToUSD; }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}