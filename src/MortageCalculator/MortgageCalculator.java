package MortageCalculator;

public class MortgageCalculator {
    private final static  byte NUMBEROFMONTHS =12;
    private final static byte PERCENTAGE =100;

    private final int principal;
    private final byte years;
    private final float interestRate;

    public MortgageCalculator(float interestRate, byte years, int principal) {
        this.interestRate = interestRate;
        this.years = years;
        this.principal = principal;
    }

    public double calculateMortgage(){
        float monthlyrate=getMonthlyRate();
        int numberOfMonths = getNumberOfPayments();
        return   principal * ((monthlyrate * calculateMonthlyRating(monthlyrate, numberOfMonths)) / (calculateMonthlyRating(monthlyrate, numberOfMonths) - 1));
    }
    public double calculateBalance(int numberOfPaymentMade){
        float monthlyrate=getMonthlyRate();
        int numberOfMonths = getNumberOfPayments();
        return  principal *((Math.pow((1+monthlyrate),numberOfMonths) -Math.pow((1+monthlyrate),numberOfPaymentMade))/
                (Math.pow((1+monthlyrate),numberOfMonths) -1));
    }
    private  double calculateMonthlyRating(float monthyrate, int numberOfMonths) {
        var result =1 +monthyrate;
        return Math.pow(result,numberOfMonths);
    }
    private int getNumberOfPayments() {
        return (years * NUMBEROFMONTHS);
    }
    private float getMonthlyRate(){
       return interestRate / PERCENTAGE / NUMBEROFMONTHS;
    }


    public double [] getRemainingBalance() {
        double [] list = new double[getNumberOfPayments()];
        for (int month = 1; month <= getNumberOfPayments(); month++) {
            double balance = calculateBalance(month);
            list[month-1]=balance;
        }
        return list;
    }
}
