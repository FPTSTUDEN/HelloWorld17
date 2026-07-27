package e6_2;
// Controller: ConverterController.java
public class ConverterController {
    public double convert(double amount, Currency source, Currency target) {
        return amount * (target.getRateToUSD() / source.getRateToUSD());
    }
}
