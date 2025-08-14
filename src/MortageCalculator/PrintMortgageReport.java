package MortageCalculator;

import java.text.NumberFormat;

public class PrintMortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator mortgageCalculator;

    public PrintMortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public   void printMortgageReport() {
        System.out.println("Welcome to Mortgage Calculator");
        System.out.println("..............................");

        printMonthlyMortgage();
        printMonthylySchedule();
    }

    private  void printMonthlyMortgage() {

        double morgage = mortgageCalculator.calculateMortgage();
        var mortgageCurrency = currency.format(morgage);
        System.out.println("MORTGAGE");
        System.out.println("........");
        System.out.println("Monthly Payments: "+mortgageCurrency);
    }
    private  void printMonthylySchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("..............");
        var balances =mortgageCalculator.getRemainingBalance();
        for (var balance:balances) {
           var balanceFormatted= currency.format(balance);
            System.out.println(balanceFormatted);
        }

    }
}
