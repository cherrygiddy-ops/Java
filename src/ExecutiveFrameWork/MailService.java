package ExecutiveFrameWork;

import java.util.concurrent.CompletableFuture;

public class MailService {
    public static void send(){
        LongTask.simulate();
        System.out.println("mail was send");
    }
    public static CompletableFuture<Void> sendAsync(){
        return CompletableFuture.runAsync(MailService::send);
    }
}
