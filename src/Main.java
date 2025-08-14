
import exceptions.Account;
import exceptions.ExceptionDemo;
import exceptions.InsuficientFundsException;
import learning.TextBox;
import learning.UIControl;
import taxCalculator.TaxCalculator2018;
import taxCalculator.TaxReport;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

       var account = new Account();
        try {
            account.withdraw(50);
        } catch (InsuficientFundsException e) {
            System.out.println(e.getMessage());
        }
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
