package Generics;

public class Utils {
    public static void printUser(User user){
        System.out.println(user);
    }
    public static  void  printUsers(GenericList<? extends User> users){
 // This means we can pass ay user Object or its Derivative

    }
}
