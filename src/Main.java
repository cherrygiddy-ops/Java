
import MortageCalculator.Console;
import MortageCalculator.MortgageCalculator;
import MortageCalculator.PrintMortgageReport;
import learning.CheckBox;
import learning.TextBox;
import learning.UIControl;
import taxCalculator.TaxCalculator2018;
import taxCalculator.TaxCalculator2019;
import taxCalculator.TaxReport;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        var calculator = new TaxCalculator2018(2000);
     var report = new TaxReport(calculator);
     report.printTax();
}

public static void  show(UIControl control){
    TextBox textbox;
        if (control instanceof TextBox){
        textbox = (TextBox) control;
        textbox.setText("cherry");
        }
       System.out.println();
}






    }
