package Generics;

public class GenericList<T > {
    //GenericList<T extends Number> -> By using extends keyword in Generic Classes means that we are restricting the operation that class offers to the Type
    private T[] items =(T[]) new Object[5];
    private int count;

    public void add(T item){
        items[count++]=item;
    }
    public T getItem(int index){
        return items[index];
    }

}
