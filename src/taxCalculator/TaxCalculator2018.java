package taxCalculator;

public class TaxCalculator2018 implements TaxCalculator{
    private double taxableIncome;

    public TaxCalculator2018(double taxableIncome) {
        setTaxableIncome(taxableIncome);
    }

    public double calculateTax(){
        return taxableIncome *0.16;
    }




    private void setTaxableIncome(double taxableIncome) {
        if (taxableIncome<0)
            throw new IllegalArgumentException();
        this.taxableIncome = taxableIncome;
    }
}
