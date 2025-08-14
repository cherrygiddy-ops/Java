package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionDemo {




    public static void show(){
        try {
            int ch;
            try (
                    var reader = new FileReader("filename.txt");
                    var writer = new FileWriter("filename.txt");

            ) {
                ch = reader.read();
              var writerc=  writer.append('c');
                System.out.println(writerc);
            }
            System.out.println(ch);
        }catch (FileNotFoundException ex){
            System.out.println("file not found exeption");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static  String toUpperCase(String name){
        return name.toUpperCase();
    }
}
