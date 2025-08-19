package PriceBestFinder;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Demo {
    public static void show() {
        var start = LocalTime.now();
       var futures= FlightService.getQuotes().map(q->q.thenAccept(System.out::println)).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRunAsync(()->{
         var end =LocalTime.now();
         var duration = Duration.between(start,end);
            System.out.println("Retrieved all Quotes in "+duration.toMillis()+" msec");
        });
    }
}
