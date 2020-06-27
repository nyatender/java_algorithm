package Grokking_java_interview.Multithreading;

import java.util.concurrent.CompletableFuture;

public class AsyncAndWait {

    /*
    <dependency>
    <groupId>com.ea.async</groupId>
    <artifactId>ea-async</artifactId>
    <version>1.2.3</version>
</dependency>
     */
    public Long factorial(int num)
    {
        Long result = 100l;
        return result;
    }
    static {
        //Async.init();
    }

    public long factorialUsingEAAsync(int number) {
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> factorial(number));
        long result = 0;
        //result = Async.await(completableFuture);

        return result;
    }
}