package taxCalculator;

public class TaxReport {
    private final TaxCalculator calculator;

    public TaxReport(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    public void printTax(){
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }
}
