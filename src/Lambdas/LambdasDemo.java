package Lambdas;

import java.util.Arrays;
import java.util.function.*;

public class LambdasDemo {
    public static void  show(){
      binaryInterface();
    }


    private static void functionInterface(){
        Function<String,Integer> map = String::length;
        var lenght = map.apply("Hello");
        System.out.println(lenght);
    }
    private static void composingFunction(){
        //key:value
        Function<String,String> replaceColon = str->str.replace(":","=");
        Function<String,String> addBraces = str-> "{ "+str+" }";
         var newString =replaceColon.andThen(addBraces).apply("key:value");
        System.out.println(newString);
    }
    private static void predicateInterface() {
        Predicate<String> has5Characters = s -> s.length() >=5;
        System.out.println(has5Characters.test("hello"));
    }
    private static void binaryInterface() {
       // BinaryOperator<Integer>add = Integer::sum;
        BiFunction<Integer,Integer,Integer> add = (a,b)->a*b;
        Function<Integer,Integer>square=(a)->a*a;
        var results =add.andThen(square).apply(7,9);
        System.out.println(results);

    }
    private static void consumerInterface() {
        var list = Arrays.asList(4,7,8,9);
        Consumer<Integer>prints = System.out::println;
        Consumer<Integer>add=(item)-> System.out.println(item+1);
        list.forEach(prints.andThen(add));//chaining of consumer
    }

    private static void supplierInterface(){
        Supplier<Double> getRandom = Math::random;
        System.out.println(getRandom.get());
    }
    public static void prints(Printer printer){
        printer.prints("Hello");
    }
}
