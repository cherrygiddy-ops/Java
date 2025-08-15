
import Generics.GenericList;
import Generics.Instructor;
import Generics.User;
import Generics.Utils;
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
       var list = new GenericList<Instructor>();
        Utils.printUsers(list);
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
