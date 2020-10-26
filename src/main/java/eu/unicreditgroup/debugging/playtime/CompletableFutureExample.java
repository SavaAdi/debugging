package eu.unicreditgroup.debugging.playtime;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CompletableFutureExample {

    public static final Long[] listOfLongs = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L};

    public static final Long DEFAULT_FOR_TIMEOUT = 1000000L;

    private static final Executor executor =
            Executors.newFixedThreadPool(Math.min(listOfLongs.length, 100),
                    (Runnable r) -> {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        return t;
                    }
            );

    public static Long longMethod(Long number) {
        try{
            Thread.sleep(1001);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return number + 100000L;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(Arrays.stream(listOfLongs).parallel().map(CompletableFutureExample::longMethod).collect(Collectors.toSet()));
        System.out.println(System.currentTimeMillis() - startTime);

        long startTime2 = System.currentTimeMillis();
        List<CompletableFuture<Long>> sums = Arrays.stream(listOfLongs)
                .map(number -> CompletableFuture.supplyAsync(
                        () -> longMethod(number))).collect(toList());
//        YOU MUST USE JOIN, OTHERWISE THEY WILL RUN SEQUENTIALLY IF YOU"D USE ONLY THE FIRST ONE
//        Sucks if you use more threads than you have available
        System.out.println(sums.stream().map(CompletableFuture::join).collect(toList()));
        System.out.println(System.currentTimeMillis() - startTime2);

        long startTime3 = System.currentTimeMillis();
        List<CompletableFuture<Long>> optimalSums = Arrays.stream(listOfLongs)
                .map(number -> CompletableFuture.supplyAsync(
                        () -> longMethod(number), executor)
                        .completeOnTimeout(DEFAULT_FOR_TIMEOUT, 1, TimeUnit.SECONDS))
                .collect(toList());

        System.out.println(optimalSums.stream().map(CompletableFuture::join).collect(toList()));
        System.out.println(System.currentTimeMillis() - startTime3);

    }
}
