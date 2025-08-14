package MortageCalculator;

import java.util.Scanner;

public class Console {
     private static  Scanner scanner = new Scanner(System.in);
    public  static   float readeUserInput(String promp, int min, int max){
        float input;
        while (true){
            System.out.print("Please Enter"+promp+"  Value between ("+min+ " && "+max+"):  ");
            input=  scanner.nextFloat();
            if (input >=min && input <=max)
                break;
            System.out.println("enter value btwn"+min+ " and "+max);
        }
        return input;
    }
    public  static   float readeUserInput(String promp){
       return scanner.nextFloat();
    }
}
