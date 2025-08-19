package ExecutiveFrameWork;

import streams.Genre;
import streams.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class ExecutorsDemo {

    /**
     * id->email
     * email->playlist
     * */

    private static CompletableFuture<String> getEmailAsync(){
        return CompletableFuture.supplyAsync(()->"email");
    }
    private static CompletableFuture<String> getPlaylistAsync(){
        return CompletableFuture.supplyAsync(()->"playlist");
    }
    public static void composingCompleteableFutures(){
         getEmailAsync().thenComposeAsync(email->getPlaylistAsync()).thenAcceptAsync(System.out::println);
    }
    public static void combiningCompletableFuture(){
        var first =CompletableFuture.supplyAsync(()->"20USD")
                                   .thenApply(p->{//Transformation
                                      var price= p.replace("USD","");
                                       return Integer.parseInt(price);
                                   });
        var second =CompletableFuture.supplyAsync(()->0.9);

        first.thenCombine(second,(price,exchangeRate)->price*exchangeRate)
                .thenAccept(System.out::println);
    }
    public static void waitingForManyTaskToComplete(){
       var first=CompletableFuture.supplyAsync(()->2);
        var second=CompletableFuture.supplyAsync(()->3);
        var third=CompletableFuture.supplyAsync(()->4);

      var future=  CompletableFuture.allOf(first,second,third).thenRunAsync(()->{
            try {
                var firstR =first.get();
                var secondR =second.get();
                var thirdR =third.get();

                System.out.println(firstR +secondR +thirdR);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });


    }
    public static void waitingForFirstTaskToComplete() {
        var first = CompletableFuture.supplyAsync(() -> {
                LongTask.simulate();
                return 2;});
        var second = CompletableFuture.supplyAsync(() ->{
            //LongTask.simulate2();
          return 30;
        });
        var results=second.completeOnTimeout(40,2,TimeUnit.SECONDS);

        CompletableFuture.anyOf(first,second).thenAccept(System.out::println);

    }
   public static void  handlingTimeOut(){
       var future= CompletableFuture.supplyAsync(()->{
            LongTask.simulate();
            return 1;
        });
       try {
          var result= future.completeOnTimeout(4,2,TimeUnit.SECONDS).get();
           System.out.println(result);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       } catch (ExecutionException e) {
           throw new RuntimeException(e);
       }
   }
    public static void AsynchronousAPI() {
        var future=MailService.sendAsync();
        future.thenRunAsync(()->{
            System.out.println("storing it in database");
        });
        System.out.println("Hello world");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void RunCodeOnCompletionOfAsynchronousOperation() {
        Supplier<Integer> supplier = () -> 5;
        var future = CompletableFuture.supplyAsync(supplier);
        future.thenAcceptAsync((result) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });
    }
//    public static void RunCodeOnCompletionOfAsynchronousOperation() {
//            Supplier<Integer>supplier =()->5;
//            var future=CompletableFuture.supplyAsync(supplier);
//            future.thenRunAsync(()->{
//                System.out.println(Thread.currentThread().getName());
//                System.out.println("done");
//            });
//    }


public static CompletableFuture<List<Movie>>getMoviesAsync(){
        return CompletableFuture.supplyAsync(()->List.of(new Movie("a",5,Genre.DRAMA), new Movie("b",6,Genre.DRAMA),new Movie("c",8,Genre.THRILLER))
        );
}
public static void TransformingComplettableFuture(){

    var future=getMoviesAsync();
    future.thenApplyAsync(movies1 -> movies1.stream().map(Movie::getLikes).reduce(Integer::sum)).
            thenAcceptAsync(System.out::println);

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

}
public static void HandlingExceptions(){
        var future=CompletableFuture.supplyAsync(()->{
            System.out.println("Reading from a file");
            throw new IllegalArgumentException();
        });
    try {
        var bytes = future.exceptionally(ex->1).get();//using Exceptionally will make future object return a default value
        System.out.println(bytes);
    } catch (InterruptedException | ExecutionException e) {
        throw new RuntimeException(e);
    }

}
    public static void CompletableFuture(){
        Runnable task = ()->{System.out.println("g");};
        Supplier<Integer> supplier=()->1;
        var future = CompletableFuture.supplyAsync(supplier);

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    public static void collables_Futures(){
        var executor =Executors.newFixedThreadPool(3);
        try{
        var futures= executor.submit(()->{
            LongTask.simulate();
            return 1;
        });
            System.out.println("do other task");
            try {
               var result = futures.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        finally {
            executor.shutdown();
        }

    }
    public static void Runnable(){
        var executor =Executors.newFixedThreadPool(3);
        try{
            executor.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        finally {
            executor.shutdown();
        }

    }
}
