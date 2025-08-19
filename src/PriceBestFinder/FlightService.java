package PriceBestFinder;

import ExecutiveFrameWork.LongTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlightService {
    public static Stream<CompletableFuture<Quote>> getQuotes() {
       var list= Arrays.asList("site1","site2","site3");
       return list.stream().map(FlightService::getQuote);
    }
    public static CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote from this " + site);

            var random = new Random();
            LongTask.simulate2(1000+ random.nextInt(2_000));
            var price = random.nextInt(10) + 100;
            return new Quote(site, price);
        });
    }
}
