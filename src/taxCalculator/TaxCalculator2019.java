package taxCalculator;

public class TaxCalculator2019 implements TaxCalculator {
    private double taxableIncome;

    public TaxCalculator2019(double taxableIncome) {
        setTaxableIncome(taxableIncome);
    }

    @Override
    public double calculateTax(){
        return taxableIncome *0.17;
    }




    private void setTaxableIncome(double taxableIncome) {
        if (taxableIncome<0)
            throw new IllegalArgumentException();
        this.taxableIncome = taxableIncome;
    }
}
