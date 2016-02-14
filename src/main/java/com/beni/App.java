package com.beni;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    static final Logger logger = LogManager.getLogger(App.class);

    public static String wget(String url) throws IOException {
        return new BufferedReader(
                new InputStreamReader(
                        new URL(url).openStream()))
                .lines()
                .limit(10)
                .collect(Collectors.joining("\n"));
    }
    public static void main( String[] args ) throws Exception {
        logger.debug( "Hello World!" );

        Runnable task1 = new Runnable() {
            public void run() {
                logger.debug("task1");
            }
        };

        Runnable ynetGetter = () -> {
            try {
                logger.debug(wget("http://ynet.co.il"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        Callable<String> ynetCallable = () ->
                wget("http://ynet.co.il");

        task1.run();

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task1);
        Thread thread3 = new Thread(ynetGetter);
        thread3.start();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> logger.debug("hi"));
        executor.submit(ynetGetter);
        //executor.shutdown();
        //executor.awaitTermination(1, TimeUnit.MILLISECONDS);
        logger.debug("after");
        //executor.shutdownNow();

        Future<String> future = executor.submit(ynetCallable);
        while (!future.isDone()) {
            logger.debug("not done");
            TimeUnit.SECONDS.sleep(2);
        }
        List<Callable<String>> callables = Arrays.asList("http://ynet.co.il", "http://nrg.co.il", "http://bhol.co.il")
                .stream()
                .map(item ->  (Callable<String>)() -> wget(item))
                .collect(Collectors.toList());

        executor.invokeAll(callables)
                .stream()
                .map(f -> {
                    try {
                        return f.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                    return "hh";
                })
        .forEach(item -> logger.debug("prining: {}", item));

        logger.debug(future.get());



    }
}
