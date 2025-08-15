package Collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetsCollection {
    Set<String> set1 = new HashSet<>(Arrays.asList("a","b","c","d"));
    Set<String>set2 = new HashSet<>(Arrays.asList("a","b","e","f"));

    //Getting Union of the two list

    public void  getUnions(){
        set1.addAll(set2);
        System.out.println(set1);
    }
    //Get Those Items which are their in list one not appearing in list 2
    public void  getDifference(){
       set1.removeAll(set2);
        System.out.println(set1);
    }
    //Get the Common Items
    public void  getCommonItems(){
         set1.retainAll(set2);
         System.out.println(set1);
    }
}
