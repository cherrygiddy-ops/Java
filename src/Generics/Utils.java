package Generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    private GenericList<Integer> list;
    private List<String> chars;
    public static void printUser(User user){
        System.out.println(user);
    }
    public static  void  printUsers(GenericList<? extends User> users){
 // This means we can pass ay user Object or its Derivative
   for (var user:users)
       System.out.println(user);
    }
    public void add(int number){
        list.add(5);
    }
    public void addChar(){



    }
}
